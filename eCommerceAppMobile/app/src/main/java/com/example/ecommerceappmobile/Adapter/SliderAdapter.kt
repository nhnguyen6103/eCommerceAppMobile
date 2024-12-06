//package com.example.ecommerceappmobile
//
//import android.content.Context
//import android.view.LayoutInflater
//import android.view.MenuItem
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import androidx.appcompat.view.menu.MenuView.ItemView
//import androidx.recyclerview.widget.RecyclerView
//import androidx.viewpager2.widget.ViewPager2
//import com.bumptech.glide.Glide
//import com.bumptech.glide.load.resource.bitmap.CenterInside
//import com.bumptech.glide.request.RequestOptions
//import com.example.ecommerceappmobile.Model.SliderModel
//
//class SliderAdapter(
//    private var sliderItem: List<SliderModel>,
//    private val viewPager2: ViewPager2
//) : RecyclerView.Adapter<SliderAdapter.SliderViewHolder>() {
//
//    private lateinit var context: Context
//    private val runnable = Runnable {
//        sliderItem = sliderItem
//        notifyDataSetChanged()
//    }
//
//
//    override fun onCreateViewHolder(
//        parent: ViewGroup,
//        viewType: Int
//    ): SliderAdapter.SliderViewHolder {
//        context = parent.context
//        val view = LayoutInflater.from(parent.context)
//            .inflate(R.layout.slider_item_container, parent, false)
//        return SliderViewHolder(view)
//    }
//
//
//    override fun onBindViewHolder(holder: SliderAdapter.SliderViewHolder, position: Int) {
//        holder.setImage(sliderItem[position], context)
//        if (position == sliderItem.lastIndex - 1) {
//            viewPager2.post(runnable)
//
//        }
//    }
//
//    override fun getItemCount(): Int = sliderItem.size
//
//
//    class SliderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        private val imageView: ImageView = itemView.findViewById(R.id.imageSlide)
//
//        fun setImage(sliderItem: SliderModel, context: Context) {
//            val requestOptions = RequestOptions().transform(CenterInside())
//
//            Glide.with(context)
//                .load(sliderItem.url)
//                .apply(requestOptions)
//                .into(imageView)
//
//
//        }
//    }
//}

package com.example.ecommerceappmobile.Adapter

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.example.ecommerceappmobile.Model.SliderModel
import com.example.ecommerceappmobile.R

class SliderAdapter(
    private var sliderItem: List<SliderModel>,
    private val viewPager2: ViewPager2
) : RecyclerView.Adapter<SliderAdapter.SliderViewHolder>() {

    private lateinit var context: Context
    private val runnable = Runnable {
        sliderItem = sliderItem
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SliderViewHolder {
        context = parent.context
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.slider_item_container, parent, false)
        return SliderViewHolder(view)
    }

    override fun onBindViewHolder(holder: SliderViewHolder, position: Int) {
        holder.setImage(sliderItem[position], context)
        if (position == sliderItem.lastIndex - 1) {
            viewPager2.post(runnable)
        }
    }

    override fun getItemCount(): Int = sliderItem.size

    class SliderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.imageSlide)

        fun setImage(sliderItem: SliderModel, context: Context) {
            val requestOptions = RequestOptions().transform(CenterInside())

            Glide.with(context)
                .load(sliderItem.url)
                .apply(requestOptions)
                .listener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        Log.e("Glide", "Load failed for URL: ${sliderItem.url}", e)
                        return false // Tiếp tục tải mặc dù có lỗi
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        Log.d("Glide", "Load success for URL: ${sliderItem.url}")
                        return false // Tiếp tục xử lý Glide sau khi tải thành công
                    }
                })
                .into(imageView)

        }
    }
}
