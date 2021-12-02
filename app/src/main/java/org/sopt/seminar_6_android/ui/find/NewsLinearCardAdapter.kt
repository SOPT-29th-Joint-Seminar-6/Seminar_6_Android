package org.sopt.seminar_6_android.ui.find

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.sopt.seminar_6_android.databinding.ItemFindNewsLinearListBinding

class NewsLinearCardAdapter : RecyclerView.Adapter<NewsLinearCardAdapter.CardViewHolder>() {
    val newsList = mutableListOf<NewsLinearData>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CardViewHolder {
        val binding = ItemFindNewsLinearListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return CardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.onBind(newsList[position])
    }

    override fun getItemCount(): Int = newsList.size

    class CardViewHolder(private val binding: ItemFindNewsLinearListBinding)
        : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: NewsLinearData) {
            Glide.with(itemView).load(data.newsImg).into(binding.ivLinearNewsImg)
            binding.tvLinearNewsTitle.text = data.newsTitle
        }
    }
}