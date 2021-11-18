package org.sopt.seminar_6_android.ui.kakaotv

import android.os.Bundle
import android.service.autofill.UserData
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.sopt.seminar_6_android.databinding.FragmentKakaoTVBinding

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


        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun initAdapter() {
        kakaoTVAdapter = KakaoTVAdapter()

        binding.rvKakaotvChannel.adapter = kakaoTVAdapter

        kakaoTVAdapter.kakaoTVChannelList.addAll(
            listOf(
                KakaoTVChannelData(
                    "호재리호재리", "호재리호재리호재리호재리",
                    "호재리호재리호재리호재리", "호재리호재리호재리호재리호재리호재리"
                ),
                KakaoTVChannelData(
                    "호재리호재리", "호재리호재리호재리호재리",
                    "호재리호재리호재리호재리", "호재리호재리호재리호재리호재리호재리"
                ),
                KakaoTVChannelData(
                    "호재리호재리", "호재리호재리호재리호재리",
                    "호재리호재리호재리호재리", "호재리호재리호재리호재리호재리호재리"
                ),
                KakaoTVChannelData(
                    "호재리호재리", "호재리호재리호재리호재리",
                    "호재리호재리호재리호재리", "호재리호재리호재리호재리호재리호재리"
                ),
                KakaoTVChannelData(
                    "호재리호재리", "호재리호재리호재리호재리",
                    "호재리호재리호재리호재리", "호재리호재리호재리호재리호재리호재리"
                ), KakaoTVChannelData(
                    "호재리호재리", "호재리호재리호재리호재리",
                    "호재리호재리호재리호재리", "호재리호재리호재리호재리호재리호재리"
                )


            )

        )

        kakaoTVAdapter.notifyDataSetChanged()
    }




}