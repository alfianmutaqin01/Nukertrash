package com.app.nukertrash.view.masyarakat.artikel.adapter

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.app.nukertrash.data.model.request.Article
import com.app.nukertrash.databinding.CustomListArtikelBinding

class ArtikelMasyarakatAdapter (private var itemList: List<Article>) : RecyclerView.Adapter<ArtikelMasyarakatAdapter.ViewHolder>() {
    class ViewHolder(val binding: CustomListArtikelBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = CustomListArtikelBinding.inflate(
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
        holder.binding.tvTitle.text = itemList[position].title
        holder.binding.cardView.setOnClickListener{
            val bundle = Bundle()
            bundle.putString("title", itemList[position].title)
            bundle.putString("content", itemList[position].content)
            bundle.putString("date", itemList[position].date)
            Navigation.findNavController(it).navigate(com.app.nukertrash.R.id.action_listArtikelFragment_to_detailArtikelFragment, bundle)

        }
    }


    @SuppressLint("NotifyDataSetChanged")
    fun setDataArticle(article: ArrayList<Article>){
        this.itemList = article
        notifyDataSetChanged()
    }


}