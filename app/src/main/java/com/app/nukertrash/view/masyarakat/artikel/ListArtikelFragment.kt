package com.app.nukertrash.view.masyarakat.artikel

import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.nukertrash.data.model.request.Article
import com.app.nukertrash.databinding.FragmentListArtikelBinding
import com.app.nukertrash.view.masyarakat.artikel.adapter.ArtikelMasyarakatAdapter
import com.app.nukertrash.view.masyarakat.artikel.viewmodel.ArtikelViewModel

class ListArtikelFragment : Fragment() {
    private lateinit var binding: FragmentListArtikelBinding
    private lateinit var artikelAdapter: ArtikelMasyarakatAdapter
    lateinit var vmArticle : ArtikelViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListArtikelBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataArticle()
        setupViewModel()

        binding.apply {
            searchbox.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(query: String?): Boolean {
                    vmArticle.searchArticle(query.orEmpty())
                    return true
                }
            })
            val hint = "Cari"
            val spannableHint = SpannableString(hint)
            spannableHint.setSpan(ForegroundColorSpan(Color.parseColor("#00AF76")), 0, hint.length, 0)
            searchbox.queryHint = spannableHint

            btnBack.setOnClickListener{
                findNavController().navigateUp()
            }
        }
    }

    fun dataArticle(){
        artikelAdapter = ArtikelMasyarakatAdapter(ArrayList())
        binding.rvArtikel.adapter = artikelAdapter
        binding.rvArtikel.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
    }

    private fun setupViewModel() {
        vmArticle = ViewModelProvider(requireActivity()).get(ArtikelViewModel::class.java)
        vmArticle.getArticleList()
        vmArticle._listArticle.observe(viewLifecycleOwner){
            artikelAdapter.setDataArticle(it as ArrayList<Article>)
        }
    }
}
