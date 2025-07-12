package com.app.nukertrash.view.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.navigation.fragment.findNavController
import com.app.nukertrash.R
import com.app.nukertrash.data.datastore.SharedPref
import com.app.nukertrash.data.model.request.UpdateProfileRequest
import com.app.nukertrash.databinding.FragmentEditProfileBinding
import com.app.nukertrash.view.profile.viewmodel.ProfileViewModel

class EditProfileFragment : Fragment() {
    lateinit var binding : FragmentEditProfileBinding
    private lateinit var sharedPref: SharedPref
    lateinit var viewModel : ProfileViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentEditProfileBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPref = SharedPref(requireContext())
        viewModel = ViewModelProvider(requireActivity())[ProfileViewModel::class.java]

        fetchUser()

        binding.apply {
            btnBack.setOnClickListener{
                findNavController().navigateUp()
            }

            btnUpdate.setOnClickListener{
                updateProfile()
            }
        }

    }

    private fun updateProfile() {
        val email = binding.etEmail.text.toString()
        val fullName = binding.etNamaLengkap.text.toString()
        val password = binding.etKataSandi.text.toString()
        val confirmPassword = binding.etUlangiKataSandi.text.toString()
        val phoneNumber = binding.etNoHp.text.toString()
        val address = binding.etAlamat.text.toString()
        val username = binding.etUsername.text.toString()

        if (email.isEmpty() || fullName.isEmpty() || password.isEmpty() ||
            confirmPassword.isEmpty() || phoneNumber.isEmpty() || address.isEmpty() ||
            username.isEmpty()
        ) {
            Toast.makeText(context, "Harap isi semua data!", Toast.LENGTH_SHORT).show()
            return
        }

        if (password != confirmPassword) {
            Toast.makeText(context, "Password tidak cocok!", Toast.LENGTH_SHORT).show()
            return
        }

        sharedPref.getToken.asLiveData().observe(viewLifecycleOwner) { token ->
            viewModel.profileUpdate(
                token, UpdateProfileRequest(
                    null,
                    null,
                    null,
                    email,
                    fullName,
                    password,
                    confirmPassword,
                    phoneNumber.toLong(),
                    address.toInt(),
                    username
                )
            )
        }

        viewModel.updateProfile().observe(viewLifecycleOwner) {
            if (it != null) {
                Toast.makeText(context, "Update Berhasil", Toast.LENGTH_SHORT).show()
                findNavController().navigateUp()
            } else {
                Toast.makeText(context, "Update Gagal", Toast.LENGTH_SHORT).show()
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
                    etEmail.setText(it.data!!.email)
                    etNamaLengkap.setText(it.data!!.fullName.toString())
                    etNoHp.setText(it.data!!.phoneNumber.toString())
                    etAlamat.setText(it.data!!.rt.toString())
                    etUsername.setText(it.data!!.username.toString())
//                    Glide.with(requireContext()).load(it.data!!.photo).into(imgProfile)
                }
            } else {
                Toast.makeText(context, "Data tidak ditemukan", Toast.LENGTH_SHORT).show()
            }
        }
    }
}