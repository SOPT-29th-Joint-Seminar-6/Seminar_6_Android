package org.sopt.seminar_6_android.ui.find

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.sopt.seminar_6_android.databinding.ItemFindNewsGridListBinding

class NewsCardAdapter : RecyclerView.Adapter<NewsCardAdapter.CardViewHolder>() {
    val newsList = mutableListOf<NewsGridData>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CardViewHolder {
        val binding = ItemFindNewsGridListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return CardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.onBind(newsList[position])
    }

    override fun getItemCount(): Int = newsList.size

    class CardViewHolder(private val binding: ItemFindNewsGridListBinding)
        : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: NewsGridData) {
            Glide.with(itemView).load(data.newsImg).into(binding.ivMovieImg)
            binding.tvMovieTitle.text = data.newsTitle
        }
    }
}