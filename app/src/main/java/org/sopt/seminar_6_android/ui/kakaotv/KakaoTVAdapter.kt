package org.sopt.seminar_6_android.ui.kakaotv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.sopt.seminar_6_android.data.model.response.ResponseKakaotvThumbnailData
import org.sopt.seminar_6_android.databinding.ItemKakaotvListBinding

class KakaoTVAdapter : RecyclerView.Adapter<KakaoTVAdapter.KakaoTVViewHolder>() {

    val kakaoTVChannelList : MutableList<ResponseKakaotvThumbnailData.Post> = mutableListOf<ResponseKakaotvThumbnailData.Post>()

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
        fun onBind(data: ResponseKakaotvThumbnailData.Post) {
            binding.btnBell.setOnClickListener {
                binding.btnBell.isSelected = !binding.btnBell.isSelected
                // 누를떄마다 현재값의 반대값으로 바뀜

            }
            binding.tvVideoTitle.text = data.title
            binding.tvVideoIntro.text = data.desc
            binding.tvChannelName.text = data.videos[0].title
            binding.tvChannelIntro.text = data.videos[0].desc
            Glide.with(binding.ivVideoThumbnail).load(data.thumbnailImageUrl).into(binding.ivVideoThumbnail)
        }
    }
}



