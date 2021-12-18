package com.coupang_olz.coupang_eats.ui.main.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.coupang_olz.coupang_eats.data.local.Store
import com.coupang_olz.coupang_eats.databinding.ItemHomeTastyBinding

class HomeTastyRVAdapter(): RecyclerView.Adapter<HomeTastyRVAdapter.ViewHolder>() {
    private val stores = ArrayList<Store>()

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): HomeTastyRVAdapter.ViewHolder {
        val binding: ItemHomeTastyBinding = ItemHomeTastyBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = stores.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(stores[position])
    }

    fun addStore(store: Store) {
        stores.add(store)
        notifyDataSetChanged()
    }

    inner class ViewHolder(val binding: ItemHomeTastyBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(store: Store){
            binding.homeTastyStoreTitleTv.text = store.title
        }
    }
}