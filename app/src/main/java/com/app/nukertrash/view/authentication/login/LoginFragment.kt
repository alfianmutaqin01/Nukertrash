package com.app.nukertrash.view.authentication.login

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.app.nukertrash.R
import com.app.nukertrash.data.datastore.SharedPref
import com.app.nukertrash.data.model.request.LoginRequest
import com.app.nukertrash.databinding.FragmentLoginBinding
import com.app.nukertrash.view.authentication.viewmodel.AuthenticationViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class LoginFragment : Fragment() {
    lateinit var binding : FragmentLoginBinding
    private lateinit var sharedPref: SharedPref
    lateinit var viewModel : AuthenticationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPref = SharedPref(requireContext())
        viewModel = ViewModelProvider(requireActivity())[AuthenticationViewModel::class.java]



        binding.apply {
            lupaKataSandi.setOnClickListener{
                findNavController().navigate(R.id.action_loginFragment_to_forgotFragment)
            }
            daftar.setOnClickListener{
                findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
            }
            btnMasuk.setOnClickListener{
                login()
            }
        }
    }

    private fun saveSession(token: String, role: String) {
        lifecycleScope.launch(Dispatchers.IO) {
            sharedPref.saveLog(token, role)
        }
    }


    fun login() {
        try {
            val email = binding.editTextEmail.text.toString()
            val password = binding.editTextKataSandi.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(requireContext(), "Harap isi semua data!", Toast.LENGTH_SHORT).show()
                return
            }

            val request = LoginRequest(email, password)
            viewModel.loginUser(request)

            viewModel.login().observe(viewLifecycleOwner) {
                if (it != null) {
                    saveSession(it.data!!.token.toString(), it.data!!.user!!.role.toString())
                    Log.d("token", it.data!!.token.toString())
                    if (it.data!!.user!!.role.toString().equals("user")){
                        Toast.makeText(requireContext(), "Berhasil Masuk!", Toast.LENGTH_SHORT).show()
                        findNavController().navigate(R.id.action_loginFragment_to_homeMasyarakatFragment)
                    } else if(it.data!!.user!!.role.toString().equals("petugas")){
                        Toast.makeText(requireContext(), "Berhasil Masuk!", Toast.LENGTH_SHORT).show()

                        findNavController().navigate(R.id.action_loginFragment_to_homePetugasFragment)
                    } else {
                        Toast.makeText(requireContext(), "Berhasil Masuk!", Toast.LENGTH_SHORT).show()

                        findNavController().navigate(R.id.action_loginFragment_to_homeAdminFragment)
                    }
                } else {
                    Toast.makeText(requireContext(), "Email atau password salah!", Toast.LENGTH_SHORT).show()
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(requireContext(), "An error occurred during login", Toast.LENGTH_SHORT).show()
        }
    }
}