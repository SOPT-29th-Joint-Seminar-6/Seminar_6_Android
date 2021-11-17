package org.sopt.seminar_6_android.ui.kakaotv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.seminar_6_android.databinding.ItemKakaotvListBinding

class KakaoTVAdapter : RecyclerView.Adapter<KakaoTVAdapter.KakaoTVViewHolder>() {

    val kakaoTVChannelList = mutableListOf<KakaoTVChannelData>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): KakaoTVAdapter.KakaoTVViewHolder {
        val binding = ItemKakaotvListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )

        return KakaoTVViewHolder(binding)
    }

    override fun onBindViewHolder(holder: KakaoTVAdapter.KakaoTVViewHolder, position: Int) {
        holder.onBind(kakaoTVChannelList[position])
    }

    override fun getItemCount(): Int = kakaoTVChannelList.size

    class KakaoTVViewHolder(private val binding: ItemKakaotvListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: KakaoTVChannelData) {
            binding.tvVideoTitle.text = data.video_title
            binding.tvVideoIntro.text = data.video_intro
            binding.tvChannelName.text = data.channel_name
            binding.tvChannelIntro.text = data.channel_intro
        }
    }
}



