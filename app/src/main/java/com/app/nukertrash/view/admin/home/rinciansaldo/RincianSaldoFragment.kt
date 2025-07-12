package com.app.nukertrash.view.admin.home.rinciansaldo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.nukertrash.R
import com.app.nukertrash.databinding.FragmentRincianSaldoBinding


class RincianSaldoFragment : Fragment() {
    lateinit var binding : FragmentRincianSaldoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRincianSaldoBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}