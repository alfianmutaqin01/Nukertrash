package com.app.nukertrash.view.masyarakat.home

import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.nukertrash.R
import com.app.nukertrash.data.model.request.Article
import com.app.nukertrash.databinding.FragmentHomeMasyarakatBinding
import com.app.nukertrash.view.masyarakat.home.adapter.HomeMasyarakatAdapter

class HomeMasyarakatFragment : Fragment() {
    lateinit var binding : FragmentHomeMasyarakatBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeMasyarakatBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val text = "Hari ini mau menukar sampah apa?"
        val builder = SpannableStringBuilder(text)

        val whiteSpan = ForegroundColorSpan(Color.BLACK)
        builder.setSpan(whiteSpan, 0, text.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        val greenSpan = ForegroundColorSpan(Color.parseColor("#009343"))
        builder.setSpan(greenSpan, text.indexOf("sampah"), text.indexOf("sampah") + "sampah".length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)


        binding.ivProfile.setOnClickListener{
            findNavController().navigate(R.id.action_homeMasyarakatFragment_to_profileFragment)
        }
        val articles = listOf(
            Article(
                "Cara Menjadi Kontributor NUKERTRASH",
                "Ingin berkontribusi untuk keberlanjutan lingkungan? Temukan caranya di sini!",
                "January 25, 2024"
            ),
            Article(
                "Tips Mengelola Sampah Rumah Tangga",
                "Pelajari cara efektif mengelola sampah di rumah tangga untuk hidup lebih berkelanjutan.",
                "January 24, 2024"
            ),
        )

        val adapter = HomeMasyarakatAdapter(articles)


        binding.apply {
            greeting.text = builder
            rvArtikel.adapter = adapter
            rvArtikel.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

            tvLihatSemua.setOnClickListener{
                findNavController().navigate(R.id.action_homeMasyarakatFragment_to_listArtikelFragment)
            }
        }

    }

}