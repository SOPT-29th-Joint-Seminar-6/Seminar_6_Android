package org.sopt.seminar_6_android.ui.kakaotv

import android.app.Service
import android.os.Bundle
import android.service.autofill.UserData
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.sopt.seminar_6_android.data.api.ServiceCreator
import org.sopt.seminar_6_android.data.model.response.ResponseKakaotvThumbnailData
import org.sopt.seminar_6_android.databinding.FragmentKakaoTVBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class KakaoTVFragment : Fragment() {
    private lateinit var kakaoTVAdapter: KakaoTVAdapter
    private var _binding: FragmentKakaoTVBinding? = null
    private val binding get() = _binding ?: error("binding이 초기화 되지 않았습니다.")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentKakaoTVBinding.inflate(layoutInflater, container, false)

        initAdapter()
        initNetwork()


        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initNetwork() {

        val call: Call<ResponseKakaotvThumbnailData> = ServiceCreator.kakaoTVService.getVideoList()

        call.enqueue(object : Callback<ResponseKakaotvThumbnailData> {
            override fun onResponse(
                call: Call<ResponseKakaotvThumbnailData>,
                response: Response<ResponseKakaotvThumbnailData>
            ) {
                if (response.isSuccessful) {
                    val data = response.body()?.data
                    if (data != null) {
                        kakaoTVAdapter.kakaoTVChannelList.addAll(data)
                        kakaoTVAdapter.notifyDataSetChanged()

                    }

                }
            }

            override fun onFailure(call: Call<ResponseKakaotvThumbnailData>, t: Throwable) {
            }
        })


    }

    private fun initAdapter() {
        kakaoTVAdapter = KakaoTVAdapter()

        binding.rvKakaotvChannel.adapter = kakaoTVAdapter

    }


}



