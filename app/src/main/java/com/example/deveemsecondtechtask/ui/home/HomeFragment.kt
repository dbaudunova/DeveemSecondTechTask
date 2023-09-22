package com.example.deveemsecondtechtask.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.deveemsecondtechtask.R
import com.example.deveemsecondtechtask.databinding.FragmentHomeBinding
import com.example.deveemsecondtechtask.ui.home.adapter.AvtoAdapter
import com.example.deveemsecondtechtask.ui.home.adapter.PromotionAdapter
import com.example.deveemsecondtechtask.ui.home.adapter.RecommendedProductsAdapter
import com.google.android.material.bottomsheet.BottomSheetDialog
import me.relex.circleindicator.CircleIndicator3

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var avtoAdapter: AvtoAdapter
    private lateinit var promotionAdapter: PromotionAdapter
    private lateinit var recommendedProductsAdapter: RecommendedProductsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAvtoAdapter()
        setPromotionAdapter()
        setRecommendedProductsAdapter()
        initListener()
    }

    private fun initListener() {
        binding.btnCreateEvent.setOnClickListener {

            //BottomSheet
            val view: View =
                layoutInflater.inflate(R.layout.bottom_sheet_layout, binding.root, false)
            val dialog = BottomSheetDialog(requireContext())
            dialog.setContentView(view)

            //Chips
            val btnPlusTen = dialog.findViewById<TextView>(R.id.chip_plus_ten)
            btnPlusTen?.setOnClickListener {
                val btnDtp = dialog.findViewById<TextView>(R.id.chip_dtp)
                val btnRepair = dialog.findViewById<TextView>(R.id.chip_repair)
                val btnCleaning = dialog.findViewById<TextView>(R.id.chip_cleaning)
                btnPlusTen.isVisible = false
                btnDtp?.isVisible = true
                btnRepair?.isVisible = true
                btnCleaning?.isVisible = true
            }

            //showing EditText
            val ivPlus = dialog.findViewById<ImageView>(R.id.iv_plus)
            val ivMinus = dialog.findViewById<ImageView>(R.id.iv_minus)
            val etComment = dialog.findViewById<EditText>(R.id.et_comment)
            val btnDone = dialog.findViewById<TextView>(R.id.btn_done)
            ivPlus?.setOnClickListener {
                ivPlus.isVisible = false
                ivMinus?.isVisible = true
                etComment?.isVisible = true
            }

            ivMinus?.setOnClickListener {
                ivPlus?.isVisible = true
                ivMinus.isVisible = false
                etComment?.isVisible = false
            }

            //Close BottomSheet
            btnDone?.setOnClickListener {
                dialog.dismiss()
            }

            dialog.show()
        }
    }

    private fun setRecommendedProductsAdapter() {
        recommendedProductsAdapter = RecommendedProductsAdapter()
        binding.rvProducts.adapter = recommendedProductsAdapter
    }


    private fun setPromotionAdapter() {
        promotionAdapter = PromotionAdapter()
        binding.vpPromotion.adapter = promotionAdapter
        val indicator: CircleIndicator3 = binding.promotionIndicator
        val viewPager = binding.vpPromotion
        indicator.setViewPager(viewPager)
    }

    private fun setAvtoAdapter() {
        avtoAdapter = AvtoAdapter()
        binding.viewPager.adapter = avtoAdapter
        val indicator: CircleIndicator3 = binding.indicator
        val viewPager = binding.viewPager
        indicator.setViewPager(viewPager)
    }
}