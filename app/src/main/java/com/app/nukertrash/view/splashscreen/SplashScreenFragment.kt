package com.app.nukertrash.view.splashscreen

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.asLiveData
import androidx.navigation.Navigation
import com.app.nukertrash.R
import com.app.nukertrash.data.datastore.SharedPref
import com.app.nukertrash.databinding.FragmentSplashScreenBinding

class SplashScreenFragment : Fragment() {
    lateinit var binding : FragmentSplashScreenBinding
    private lateinit var sharedPref: SharedPref

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSplashScreenBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPref = SharedPref(requireContext())

        startSplashScreen()

    }

    private fun startSplashScreen() {
        sharedPref.getToken.asLiveData().observe(viewLifecycleOwner){
            Handler(Looper.getMainLooper()).postDelayed({
                if (it.equals("Undefined")){
                    Log.d("token pas function gettoken", it)
                    Navigation.findNavController(requireView()).navigate(R.id.action_splashScreenFragment_to_onBoardingFragment)
                }else{
                    sharedPref.getRole.asLiveData().observe(viewLifecycleOwner){role ->
                        if (role.equals("user")){
                            Navigation.findNavController(requireView()).navigate(R.id.action_splashScreenFragment_to_homeMasyarakatFragment)
                        }else if(role.equals("petugas")){
                            Navigation.findNavController(requireView()).navigate(R.id.action_splashScreenFragment_to_homePetugasFragment)
                        }else if (role.equals("admin")){
                            Navigation.findNavController(requireView()).navigate(R.id.action_splashScreenFragment_to_homeAdminFragment)
                        }else{
                            Navigation.findNavController(requireView()).navigate(R.id.action_splashScreenFragment_to_onBoardingFragment)
                        }
                    }
                }
            }, 1000)
        }
    }
}