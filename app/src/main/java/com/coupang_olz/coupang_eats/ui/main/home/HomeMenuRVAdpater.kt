package com.coupang_olz.coupang_eats.ui.main.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.coupang_olz.coupang_eats.data.local.Menu
import com.coupang_olz.coupang_eats.databinding.ItemHomeMenuBinding

class HomeMenuRVAdpater(): RecyclerView.Adapter<HomeMenuRVAdpater.ViewHolder>(){
    private val menus = ArrayList<Menu>()

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemHomeMenuBinding = ItemHomeMenuBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(menus[position])
    }

    override fun getItemCount(): Int = menus.size

    @SuppressLint("NotifyDataSetChanged")
    fun addAlbums(albums: ArrayList<Menu>) {
        this.menus.clear()
        this.menus.addAll(menus)

        notifyDataSetChanged()
    }

    fun addMenu(menu: Menu) {
        menus.add(menu)
        notifyDataSetChanged()
    }

    inner class ViewHolder(val binding: ItemHomeMenuBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(menu: Menu){
            binding.itemHomeMenuImgIv.setImageResource(menu.img!!)
            binding.itemHomeMenuTitleTv.text = menu.title
        }
    }
}