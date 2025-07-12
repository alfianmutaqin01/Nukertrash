package com.app.nukertrash.view.petugas.home.adapter

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.app.nukertrash.data.model.request.DaftarPickup
import com.app.nukertrash.databinding.CustomLayoutSiapDiambilBinding

class ListPickupSampahAdapter (private var itemList: List<DaftarPickup>) : RecyclerView.Adapter<ListPickupSampahAdapter.ViewHolder>() {
    class ViewHolder(val binding: CustomLayoutSiapDiambilBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = CustomLayoutSiapDiambilBinding.inflate(
            android.view.LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvNama.text = itemList[position].nama
        holder.binding.tvRtRw.text = "RT ${itemList[position].rt} / RW ${itemList[position].rw}"
        holder.binding.btnProses.setOnClickListener{
            val bundle = Bundle()
            bundle.putString("nama", itemList[position].nama)
            bundle.putString("rt", itemList[position].rt)
            bundle.putString("rw", itemList[position].rw)
            Navigation.findNavController(it).navigate(com.app.nukertrash.R.id.action_homePetugasFragment_to_prosesSampahFragment, bundle)
        }
    }


    @SuppressLint("NotifyDataSetChanged")
    fun setDataPickup(pickup: ArrayList<DaftarPickup>){
        this.itemList = pickup
        notifyDataSetChanged()
    }


}