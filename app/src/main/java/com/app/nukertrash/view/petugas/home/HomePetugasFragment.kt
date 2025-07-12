package com.app.nukertrash.view.petugas.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import android.widget.SearchView
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.nukertrash.databinding.FragmentHomePetugasBinding
import com.app.nukertrash.view.petugas.home.adapter.ListPickupSampahAdapter
import com.app.nukertrash.view.petugas.home.viewmodel.ViewModelHome

class HomePetugasFragment : Fragment() {
    private lateinit var binding: FragmentHomePetugasBinding
    private lateinit var viewModel: ViewModelHome
    private lateinit var pickupAdapter: ListPickupSampahAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomePetugasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(ViewModelHome::class.java)

        pickupAdapter = ListPickupSampahAdapter(emptyList())
        binding.rvSiapDiambil.adapter = pickupAdapter
        binding.rvSiapDiambil.layoutManager = LinearLayoutManager(context)

        binding.ivProfile.setOnClickListener{
            findNavController().navigate(com.app.nukertrash.R.id.action_homePetugasFragment_to_profileFragment)
        }

        binding.btnLihatJadwal.setOnClickListener {
            findNavController().navigate(com.app.nukertrash.R.id.action_homePetugasFragment_to_jadwalPengambilanSampahFragment)
        }

        binding.btnLihatKeteranganSampah.setOnClickListener {
            findNavController().navigate(com.app.nukertrash.R.id.action_homePetugasFragment_to_daftarSampahFragment)
        }

        viewModel._listPickup.observe(viewLifecycleOwner) { pickupList ->
            pickupAdapter.setDataPickup(pickupList as ArrayList)
        }

        viewModel.getPickupList()

        binding.searchbox.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(query: String?): Boolean {
                viewModel.searchPickup(query.orEmpty())
                return true
            }
        })
    }
}
