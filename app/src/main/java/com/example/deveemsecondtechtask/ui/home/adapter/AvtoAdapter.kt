package com.example.deveemsecondtechtask.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.deveemsecondtechtask.R
import com.example.deveemsecondtechtask.databinding.ItemViewPagerBinding
import com.example.deveemsecondtechtask.ui.home.adapter.model.Avto

class AvtoAdapter: Adapter<AvtoAdapter.AvtoViewHolder>() {

   private val data = arrayListOf(
        Avto(R.drawable.car, "C 065 MK 77", "Mercedes-Benz"),
       Avto(R.drawable.car, "C 065 MK 77", "Mercedes-Benz"),
       Avto(R.drawable.car, "C 065 MK 77", "Mercedes-Benz")
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AvtoViewHolder {
        return AvtoViewHolder(ItemViewPagerBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: AvtoViewHolder, position: Int) {
        holder.bind(data[position])
    }

    inner class AvtoViewHolder(private val binding: ItemViewPagerBinding): ViewHolder(binding.root){
        fun bind(viewPager: Avto){
            binding.apply {
                tvNumberOfAvto.text = viewPager.number
                tvNameOfAvto.text = viewPager.name
                viewPager.image?.let { ivCar.setImageResource(it) }
            }
        }
    }

}