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

    {
        "status" : 200,
        "success" : true,
        "message" : "로그인 성공"
        "data" : {
            "id" : 1,
            "name" : "김우영"
            "email" : "kimwy1997@gmail.com"
    }
    }

    data class ResponseLoginData(
        val status : Int,
        val success : Boolean,
        val message : String,
        val data : Data
    ) {
        data class Data(
            val id: Int,
            val name : String,
            val email : String
        )
    }


    data class ResponseVideoData(
        val status : Int,
        val success: Boolean,
        val message: String,
        val data : Data
    ) {
        data class Data(

        )
    }

    {
        "status": 200,
        "success": true,
        "message": "모든 비디오포스트 조회 성공",
        "data": [
        {
            "id": 1,
            "title": "6회, 속보! 신용 거래 개미 등장?!",
            "desc": "흔들리는 장중 속에서-멘탈을 잡아볼 거야  울고있는 개미",
            "thumbnailImageUrl": "장동민사진",
            "isDeleted": false,
            "videochannelId": 1,
            "videos": [
            {
                "id": 1,
                "title": "6회, 속보! 신용 거래 개미 등장?!",
                "desc": "흔들리는 장중 속에서-멘탈을 잡아볼 거야  울고있는 개미",
                "thumbnailImageUrl": "장동민사진",
                "isDeleted": false,
                "videochannelId": 1
            }
            ]
        },
        {
            "id": 2,
            "title": "4회, 잘하는 것도, 목하는 것도 없어",
            "desc": "하고 싶은 대로 살자~",
            "thumbnailImageUrl": "강아지사진",
            "isDeleted": false,
            "videochannelId": 2,
            "videos": [
            {
                "id": 2,
                "title": "4회, 잘하는 것도, 목하는 것도 없어",
                "desc": "하고 싶은 대로 살자~",
                "thumbnailImageUrl": "강아지사진",
                "isDeleted": false,
                "videochannelId": 2
            }
            ]
        }
        ]
    }



}