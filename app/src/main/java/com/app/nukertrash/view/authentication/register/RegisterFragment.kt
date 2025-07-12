package com.app.nukertrash.view.authentication.register

import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.app.nukertrash.R
import com.app.nukertrash.data.datastore.SharedPref
import com.app.nukertrash.data.model.request.LoginRequest
import com.app.nukertrash.data.model.request.RegisterRequest
import com.app.nukertrash.databinding.FragmentRegisterBinding
import com.app.nukertrash.view.authentication.viewmodel.AuthenticationViewModel

class RegisterFragment : Fragment() {
    lateinit var binding : FragmentRegisterBinding
    private lateinit var sharedPref: SharedPref
    lateinit var viewModel : AuthenticationViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPref = SharedPref(requireContext())
        viewModel = ViewModelProvider(requireActivity())[AuthenticationViewModel::class.java]


        var text = "Segera Daftar dan Tukarkan Sampahmu di NUKERTRASH!"
        val builder = SpannableStringBuilder(text)
        val greenSpan = ForegroundColorSpan(Color.parseColor("#009343")) // Green color
        builder.setSpan(greenSpan, text.indexOf("NUKERTRASH"), text.indexOf("NUKERTRASH") + "NUKERTRASH".length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        val whiteSpan = ForegroundColorSpan(Color.WHITE)
        builder.setSpan(whiteSpan, 0, text.indexOf("NUKERTRASH"), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        builder.setSpan(whiteSpan, text.indexOf("NUKERTRASH") + "NUKERTRASH".length, text.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        binding.apply {
            first.text = builder

            btnRegister.setOnClickListener{
                register()
            }
        }
    }

    private fun register() {
        val username = binding.editTextUserName.text.toString()
        val email = binding.editTextEmail.text.toString()
        val password = binding.editTextKataSandi.text.toString()
        val confirmPassword = binding.editTextKonfirmPassword.text.toString()

        if (username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            Toast.makeText(requireContext(), "Harap isi semua data!", Toast.LENGTH_SHORT).show()
            return
        }

        val request = RegisterRequest(username,email,password,confirmPassword)

        viewModel.registerUser(request)
        viewModel.register().observe(viewLifecycleOwner){
            if (it != null){
                findNavController().navigate(R.id.action_registerFragment_to_profileFragment)
            }else{
                Toast.makeText(requireContext(), "Gagal Daftar!", Toast.LENGTH_SHORT).show()
            }
        }
    }

}