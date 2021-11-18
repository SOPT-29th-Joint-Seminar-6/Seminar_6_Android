package org.sopt.seminar_6_android.ui.find

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.sopt.seminar_6_android.databinding.ItemFindNewsListBinding

class NewsCardAdapter : RecyclerView.Adapter<NewsCardAdapter.CardViewHolder>() {
    val newsList = mutableListOf<NewsData>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CardViewHolder {
        val binding = ItemFindNewsListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return CardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.onBind(newsList[position])
    }

    override fun getItemCount(): Int = newsList.size

    class CardViewHolder(private val binding: ItemFindNewsListBinding)
        : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: NewsData) {
            Glide.with(itemView).load(data.newsImg).into(binding.ivMovieImg)
            binding.tvMovieTitle.text = data.newsTitle
            Log.d("바인딩되고있니?","${data.newsImg} 뉴스 이미지 바인딩")
        }
    }
}