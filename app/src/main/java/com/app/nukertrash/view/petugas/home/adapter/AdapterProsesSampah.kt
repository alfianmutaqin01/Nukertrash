package com.app.nukertrash.view.petugas.home.adapter


import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.nukertrash.data.model.request.Sampah
import com.app.nukertrash.databinding.CustomLayoutProsesSampahBinding

class AdapterProsesSampah (private var itemList: List<Sampah>) : RecyclerView.Adapter<AdapterProsesSampah.ViewHolder>() {
    class ViewHolder(val binding: CustomLayoutProsesSampahBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = CustomLayoutProsesSampahBinding.inflate(
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
        holder.binding.jenisSampahEditText.setText(itemList[position].jenisSampah)
        holder.binding.jenisSampahEditText.isEnabled = false
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setDataPickup(pickup: ArrayList<Sampah>){
        this.itemList = pickup
        notifyDataSetChanged()
    }
}