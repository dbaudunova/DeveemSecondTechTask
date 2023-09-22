package com.example.deveemsecondtechtask.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.deveemsecondtechtask.databinding.ItemPromotionBinding
import com.example.deveemsecondtechtask.ui.home.adapter.model.Promotion

class PromotionAdapter: Adapter<PromotionAdapter.PromotionViewHolder>() {

    private val data = arrayListOf(
        Promotion("Бесплатная замена масла +\nдиагностика автомобиля", "Только до 30 апреля"),
        Promotion("Скидка \nна первый заезд"),
        Promotion("Полировка кузова\nпосле ремонта", "До 27 июня")
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PromotionViewHolder {
        return PromotionViewHolder(ItemPromotionBinding.inflate(LayoutInflater.from(parent.context), parent,false))
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: PromotionViewHolder, position: Int) {
        holder.bind(data[position])
    }

    inner class PromotionViewHolder(private val binding: ItemPromotionBinding): ViewHolder(binding.root) {
        fun bind(promotion: Promotion){
            with(binding) {
                tvFreeChangeOfOil.text = promotion.title
                tvUntil30April.text = promotion.description
            }
        }
    }

}