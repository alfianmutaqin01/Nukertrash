package com.app.nukertrash.view.petugas.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.nukertrash.data.model.request.Sampah
import com.app.nukertrash.databinding.FragmentProsesSampahBinding
import com.app.nukertrash.view.petugas.home.adapter.AdapterProsesSampah
import com.app.nukertrash.view.petugas.sampah.viewmodel.SampahViewModel

class ProsesSampahFragment : Fragment() {
    private lateinit var binding: FragmentProsesSampahBinding
    private val sampahViewModel: SampahViewModel by viewModels()
    private lateinit var adapter: AdapterProsesSampah

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProsesSampahBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        sampahViewModel.sampahList.observe(viewLifecycleOwner) { sampahList ->
            adapter.setDataPickup(sampahList as ArrayList<Sampah>)
        }

        sampahViewModel.getSampahList()

        binding.btnSimpan.setOnClickListener {
            val resultText = buildResultTextFromRecyclerView()
            Log.d("ProsesSampahFragment", "Result: $resultText")
        }
    }

    private fun setupRecyclerView() {
        adapter = AdapterProsesSampah(emptyList())
        binding.rvProsesSampah.adapter = adapter
        binding.rvProsesSampah.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun buildResultTextFromRecyclerView(): String {
        val selectedWasteTypes = ArrayList<String>()
        val selectedWeights = ArrayList<String>()

        for (i in 0 until adapter.itemCount) {
            val viewHolder = binding.rvProsesSampah.findViewHolderForAdapterPosition(i) as? AdapterProsesSampah.ViewHolder
            viewHolder?.let {
                val jenisSampah = it.binding.jenisSampahEditText.text.toString()
                val berat = it.binding.beratEditText.text.toString()

                if (berat.isNotEmpty()) {
                    selectedWasteTypes.add(jenisSampah)
                    selectedWeights.add(berat)
                }
            }
        }

        return buildResultText(selectedWasteTypes, selectedWeights)
    }


    private fun buildResultText(wasteTypes: List<String>, weights: List<String>): String {
        val resultStringBuilder = StringBuilder()
        for (i in wasteTypes.indices) {
            resultStringBuilder.append("${wasteTypes[i]}: ${weights[i]} kg\n")
        }
        return resultStringBuilder.toString()
    }
}
