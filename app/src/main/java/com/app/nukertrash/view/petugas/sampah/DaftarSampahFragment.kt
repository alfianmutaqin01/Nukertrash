package com.app.nukertrash.view.petugas.sampah

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.nukertrash.data.model.request.Sampah
import com.app.nukertrash.databinding.FragmentDaftarSampahBinding
import com.app.nukertrash.view.petugas.sampah.adapter.DaftarSampahAdapter
import com.app.nukertrash.view.petugas.sampah.viewmodel.SampahViewModel

class DaftarSampahFragment : Fragment() {

    private lateinit var binding: FragmentDaftarSampahBinding
    private lateinit var sampahViewModel: SampahViewModel
    private lateinit var daftarSampahAdapter: DaftarSampahAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDaftarSampahBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sampahViewModel = ViewModelProvider(this).get(SampahViewModel::class.java)

        daftarSampahAdapter = DaftarSampahAdapter(emptyList())

        binding.rvHargaSampah.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = daftarSampahAdapter
        }

        binding.btnTambahJenis.setOnClickListener{
            findNavController().navigate(com.app.nukertrash.R.id.action_daftarSampahFragment_to_tambahJenisSampahFragment)
        }

        sampahViewModel.sampahList.observe(viewLifecycleOwner) { sampahList ->
            daftarSampahAdapter.setDataSampah(sampahList as ArrayList<Sampah>)
        }

        sampahViewModel.getSampahList()
    }
}
