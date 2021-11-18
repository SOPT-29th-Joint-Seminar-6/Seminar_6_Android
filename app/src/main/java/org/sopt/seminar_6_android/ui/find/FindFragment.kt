package org.sopt.seminar_6_android.ui.find

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.sopt.seminar_6_android.databinding.FragmentFindBinding

class FindFragment : Fragment() {
    private var _binding: FragmentFindBinding? = null
    private val binding get() = _binding ?: error("binding이 초기화 되지 않았습니다.")
    private lateinit var newsCardAdapter: NewsCardAdapter
    private lateinit var newsLinearCardAdapter: NewsLinearCardAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFindBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
        initGridAdapter()
        initLinearAdapter()
        return binding.root
    }

    private fun initGridAdapter() {
        newsCardAdapter = NewsCardAdapter()
        binding.includeNewsCard.rvNewsCard.adapter = newsCardAdapter

        newsCardAdapter.newsList.addAll(
            listOf(
                NewsGridData("https://cdn.pixabay.com/photo/2021/11/08/11/19/buildings-6778915_1280.jpg", "설명1"),
                NewsGridData("https://cdn.pixabay.com/photo/2021/11/08/11/19/buildings-6778915_1280.jpg", "설명1"),
                NewsGridData("https://cdn.pixabay.com/photo/2021/11/08/11/19/buildings-6778915_1280.jpg", "설명1")
            )
        )
        newsCardAdapter.notifyDataSetChanged()
        Log.d("data되고있니?","${newsCardAdapter.newsList.toString()}data 들어가고있니")
    }

    private fun initLinearAdapter() {
        Log.d("init되고있니?","initAdapter 호출")
        newsLinearCardAdapter = NewsLinearCardAdapter()
        binding.includeNewsLinearCard.rvNewsCard.adapter = newsLinearCardAdapter

        newsLinearCardAdapter.newsList.addAll(
            listOf(
                NewsGridData("https://cdn.pixabay.com/photo/2021/11/08/11/19/buildings-6778915_1280.jpg", "설명1"),
                NewsGridData("https://cdn.pixabay.com/photo/2021/11/08/11/19/buildings-6778915_1280.jpg", "설명1"),
                NewsGridData("https://cdn.pixabay.com/photo/2021/11/08/11/19/buildings-6778915_1280.jpg", "설명1")
            )
        )
        newsLinearCardAdapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}