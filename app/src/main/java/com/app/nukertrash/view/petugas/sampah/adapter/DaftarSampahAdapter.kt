package com.app.nukertrash.view.petugas.sampah.adapter


import android.annotation.SuppressLint
import android.os.Bundle
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.app.nukertrash.data.model.request.DaftarPickup
import com.app.nukertrash.data.model.request.Sampah
import com.app.nukertrash.databinding.CustomLayoutSiapDiambilBinding
import com.app.nukertrash.databinding.CustomLayputHargaSampahBinding

class DaftarSampahAdapter (private var itemList: List<Sampah>) : RecyclerView.Adapter<DaftarSampahAdapter.ViewHolder>() {
    class ViewHolder(val binding: CustomLayputHargaSampahBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = CustomLayputHargaSampahBinding.inflate(
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
        holder.binding.jenisSampahTextView.text = itemList[position].jenisSampah
        holder.binding.hargaTextView.text = "Rp. ${itemList[position].harga}"
        holder.binding.customLayoutHargaSampah.setOnClickListener{
            val bundle = Bundle()
            bundle.putString("jenis", itemList[position].jenisSampah)
            bundle.putString("harga", itemList[position].harga.toString())
            Navigation.findNavController(it).navigate(com.app.nukertrash.R.id.action_daftarSampahFragment_to_editHargaSampahFragment, bundle)
        }
    }


    @SuppressLint("NotifyDataSetChanged")
    fun setDataSampah(pickup: ArrayList<Sampah>){
        this.itemList = pickup
        notifyDataSetChanged()
    }


}