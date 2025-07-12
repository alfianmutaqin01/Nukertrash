package com.app.nukertrash.view.masyarakat.home.adapter

import android.os.Bundle
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.app.nukertrash.data.model.request.Article
import com.app.nukertrash.databinding.CustomLayoutArtikelBinding

class HomeMasyarakatAdapter (private val itemList: List<Article>) : RecyclerView.Adapter<HomeMasyarakatAdapter.ViewHolder>() {
    class ViewHolder(val binding: CustomLayoutArtikelBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = CustomLayoutArtikelBinding.inflate(
            android.view.LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvJudul.text = itemList[position].title
        holder.binding.cardView.setOnClickListener{
            val bundle = Bundle()
            bundle.putString("title", itemList[position].title)
            bundle.putString("content", itemList[position].content)
            bundle.putString("date", itemList[position].date)
            Navigation.findNavController(it).navigate(com.app.nukertrash.R.id.action_homeMasyarakatFragment_to_detailArtikelFragment, bundle)

        }
    }
}