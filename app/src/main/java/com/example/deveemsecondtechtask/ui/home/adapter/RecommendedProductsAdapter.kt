package com.example.deveemsecondtechtask.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.deveemsecondtechtask.R

import com.example.deveemsecondtechtask.databinding.ItemRecommendedProductsBinding
import com.example.deveemsecondtechtask.ui.home.adapter.model.RecommendedProducts

class RecommendedProductsAdapter: RecyclerView.Adapter<RecommendedProductsAdapter.RecommendedProductsViewHolder>() {

    private val data = arrayListOf(
        RecommendedProducts(R.drawable.motor_oil, "Моторное масло \n10ZIC X9 5W-30"),
        RecommendedProducts(R.drawable.motor_oil, "Моторное масло \n10ZIC X9 5W-30"),
        RecommendedProducts(R.drawable.motor_oil, "Моторное масло \n10ZIC X9 5W-30"),
        RecommendedProducts(R.drawable.motor_oil, "Моторное масло \n10ZIC X9 5W-30"),
        RecommendedProducts(R.drawable.motor_oil, "Моторное масло \n10ZIC X9 5W-30"),
        RecommendedProducts(R.drawable.motor_oil, "Моторное масло \n10ZIC X9 5W-30"),
        RecommendedProducts(R.drawable.motor_oil, "Моторное масло \n10ZIC X9 5W-30"),
        RecommendedProducts(R.drawable.motor_oil, "Моторное масло \n10ZIC X9 5W-30")
    )

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecommendedProductsViewHolder {
        return RecommendedProductsViewHolder(ItemRecommendedProductsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: RecommendedProductsViewHolder, position: Int) {
        holder.bind(data[position])
    }


    inner class RecommendedProductsViewHolder(private val binding: ItemRecommendedProductsBinding): ViewHolder(binding.root){
        fun bind(recommendedProducts: RecommendedProducts){
            binding.run {
                tvOilName.text = recommendedProducts.name
                recommendedProducts.image?.let { ivMotorOil.setImageResource(it) }
            }
        }
    }
}