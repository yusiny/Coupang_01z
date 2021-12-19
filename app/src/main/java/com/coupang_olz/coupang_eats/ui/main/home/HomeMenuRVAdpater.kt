package com.coupang_olz.coupang_eats.ui.main.home

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.coupang_olz.coupang_eats.data.local.Category
import com.coupang_olz.coupang_eats.data.local.Menu
import com.coupang_olz.coupang_eats.databinding.ItemHomeMenuBinding

class HomeMenuRVAdpater(val context: Context): RecyclerView.Adapter<HomeMenuRVAdpater.ViewHolder>(){
    private val categories = ArrayList<Category>()

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemHomeMenuBinding = ItemHomeMenuBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(categories[position])
    }

    override fun getItemCount(): Int = categories.size

    @SuppressLint("NotifyDataSetChanged")
    fun addCategories(categories: ArrayList<Category>) {
        this.categories.clear()
        this.categories.addAll(categories)

        notifyDataSetChanged()
    }


    inner class ViewHolder(val binding: ItemHomeMenuBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(category: Category){
            if(category.categoryImg != null){
                Glide.with(context).load(category.categoryImg!!).into(binding.itemHomeMenuImgIv)
            }else{
                Glide.with(context).load(category.categoryImg!!).into(binding.itemHomeMenuImgIv)
            }
            binding.itemHomeMenuTitleTv.text = category.categoryName
        }
    }
}