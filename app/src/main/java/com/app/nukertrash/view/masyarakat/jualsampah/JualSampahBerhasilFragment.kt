package com.app.nukertrash.view.masyarakat.jualsampah

import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.nukertrash.R
import com.app.nukertrash.databinding.FragmentJualSampahBerhasilBinding

class JualSampahBerhasilFragment : Fragment() {
    lateinit var binding : FragmentJualSampahBerhasilBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentJualSampahBerhasilBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val text = "Tunggu Petugas datang menjemput sampah"
        val builder = SpannableStringBuilder(text)

        val whiteSpan = ForegroundColorSpan(Color.BLACK)
        builder.setSpan(whiteSpan, 0, text.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        val greenSpan = ForegroundColorSpan(Color.parseColor("#009343"))
        builder.setSpan(greenSpan, text.indexOf("Petugas"), text.indexOf("Petugas") + "Petugas".length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)


        binding.apply {
            greeting.text = builder
        }
    }

}