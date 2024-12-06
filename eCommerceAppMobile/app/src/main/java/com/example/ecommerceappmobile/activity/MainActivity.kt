package com.example.ecommerceappmobile.activity

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.example.ecommerceappmobile.Adapter.BrandAdapter
import com.example.ecommerceappmobile.Adapter.PopularAdapter
import com.example.ecommerceappmobile.Model.SliderModel
import com.example.ecommerceappmobile.Adapter.SliderAdapter
import com.example.ecommerceappmobile.ViewModel.MainViewModel
import com.example.ecommerceappmobile.databinding.ActivityMainBinding





class MainActivity : BaseActivity() {
    private val viewModel=MainViewModel()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        initBanner()
        initBrand()
        initPopular()
    }

    private fun initBanner() {
        binding.progressBarBanner.visibility= View.VISIBLE
        viewModel.banners.observe(this, Observer { items->
            banners(items)
            binding.progressBarBanner.visibility=View.GONE
        })
        viewModel.loadBanners()
    }

    private fun banners(images:List<SliderModel>){
        binding.viewpageSlider.adapter= SliderAdapter(images,binding.viewpageSlider)
        binding.viewpageSlider.clipToPadding=false
        binding.viewpageSlider.clipChildren=false
        binding.viewpageSlider.offscreenPageLimit=3

        val compositePageTransformer=CompositePageTransformer().apply {
            addTransformer(MarginPageTransformer(40))
        }
        binding.viewpageSlider.setPageTransformer(compositePageTransformer)
        if(images.size>1){
            binding.dotIndicator.visibility=View.VISIBLE
            binding.dotIndicator.attachTo(binding.viewpageSlider)
        }
    }

//    private fun initBrand() {
//        binding.progressBarBrand.visibility = View.VISIBLE
//        viewModel.brands.observe(this, Observer {
//            binding.viewBrand.layoutManager =
//                LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
//            binding.viewBrand.adapter = BrandAdapter(it)
//            binding.progressBarBrand.visibility = View.GONE
//        })
//        viewModel.loadBrand()
//    }
    private fun initBrand() {
        binding.progressBarBrand.visibility = View.VISIBLE
        viewModel.brands.observe(this, Observer { brands ->
            binding.recyclerView.layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            binding.recyclerView.adapter = BrandAdapter(brands)
            binding.progressBarBrand.visibility = View.GONE
        })
        viewModel.loadBrand()
    }


    private fun initPopular() {
        binding.progressBarPopular.visibility = View.VISIBLE
        viewModel.popular.observe(this, Observer {
            binding.viewPopular.layoutManager = GridLayoutManager(this@MainActivity, 2)
            binding.viewPopular.adapter = PopularAdapter(it)
            binding.progressBarPopular.visibility = View.GONE
        })
        viewModel.loadPopular()
    }
}