package com.app.nukertrash.view.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.app.nukertrash.R
import com.app.nukertrash.data.datastore.SharedPref
import com.app.nukertrash.databinding.FragmentProfileBinding
import com.app.nukertrash.view.authentication.viewmodel.AuthenticationViewModel
import com.app.nukertrash.view.profile.viewmodel.ProfileViewModel
import com.bumptech.glide.Glide
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ProfileFragment : Fragment() {
    lateinit var binding : FragmentProfileBinding
    private lateinit var sharedPref: SharedPref
    lateinit var viewModel : ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPref = SharedPref(requireContext())
        viewModel = ViewModelProvider(requireActivity())[ProfileViewModel::class.java]

        fetchUser()

        binding.apply {
            btnEditProfile.setOnClickListener{
                findNavController().navigate(R.id.action_profileFragment_to_editProfileFragment)
            }

            btnLogout.setOnClickListener{
                logout()
            }
        }
    }

    fun fetchUser(){

        sharedPref.getToken.asLiveData().observe(viewLifecycleOwner){token ->
            viewModel.profileUser(token)

        }
        viewModel.profile().observe(viewLifecycleOwner) {
            if (it != null) {
                binding.apply {
                    tvNama.text = it.data!!.fullName.toString()
                    tvEmail.text = it.data!!.email
                    tvNomorHp.text = it.data!!.phoneNumber.toString()
                    tvRole.text = it.data!!.role
                    tvRtRw.text = it.data!!.rt.toString()
                    tvUsername.text = it.data!!.username
//                    Glide.with(requireContext()).load(it.data!!.photo).into(imgProfile)

                }
            } else {
                Toast.makeText(context, "Data tidak ditemukan", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_profileFragment_to_loginFragment)
            }
        }
    }

    fun logout(){
        lifecycleScope.launch(Dispatchers.IO) {
            sharedPref.removeSession()
        }
        findNavController().navigate(R.id.action_profileFragment_to_loginFragment)
        Toast.makeText(context, "Logout berhasil", Toast.LENGTH_SHORT).show()
    }

}