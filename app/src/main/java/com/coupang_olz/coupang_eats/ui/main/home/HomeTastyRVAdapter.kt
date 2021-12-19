package com.coupang_olz.coupang_eats.ui.main.home

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.coupang_olz.coupang_eats.data.local.Category
import com.coupang_olz.coupang_eats.data.local.Store
import com.coupang_olz.coupang_eats.databinding.ItemHomeTastyBinding

class HomeTastyRVAdapter(val context: Context): RecyclerView.Adapter<HomeTastyRVAdapter.ViewHolder>() {
    private val stores = ArrayList<Store>()

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): HomeTastyRVAdapter.ViewHolder {
        val binding: ItemHomeTastyBinding = ItemHomeTastyBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = stores.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(stores[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addStores(stores: ArrayList<Store>) {
        this.stores.clear()
        this.stores.addAll(stores)

        notifyDataSetChanged()
    }

    inner class ViewHolder(val binding: ItemHomeTastyBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(store: Store){

            if(store.restImg != null){
                Glide.with(context).load(store.restImg!!).into(binding.itemTastyStoreImgIv)
            }else{
                Glide.with(context).load(store.restImg).into(binding.itemTastyStoreImgIv)
            }

            binding.itemTastyStoreTitleTv.text = store.restName
            binding.itemTastyRate.text = store.rate.toString()
            binding.itemTastyDelieveryFee.text = String.format("%d,%d", store.deliveryFee/1000, store.deliveryFee%1000)

            if(store.isCheetah == 1){ binding.itemTastyIsCheetachIv.visibility = View.VISIBLE}
            else{ binding.itemTastyIsCheetachIv.visibility = View.GONE }
        }
    }
}