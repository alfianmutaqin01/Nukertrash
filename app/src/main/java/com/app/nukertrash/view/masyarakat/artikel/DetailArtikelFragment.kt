package com.app.nukertrash.view.masyarakat.artikel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.app.nukertrash.R
import com.app.nukertrash.data.datastore.SharedPref
import com.app.nukertrash.databinding.FragmentDetailArtikelBinding

class DetailArtikelFragment : Fragment() {
    lateinit var binding : FragmentDetailArtikelBinding
    lateinit var sharedPref: SharedPref

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailArtikelBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val title = arguments?.getString("title")
        val content = arguments?.getString("content")
        val date = arguments?.getString("date")

        binding.apply {
            tvTitle.text = title
            tvDeskripsi.text = content
            tvPenulis.text = date

            btnBack.setOnClickListener{
                findNavController().navigateUp()
            }
        }
    }
}