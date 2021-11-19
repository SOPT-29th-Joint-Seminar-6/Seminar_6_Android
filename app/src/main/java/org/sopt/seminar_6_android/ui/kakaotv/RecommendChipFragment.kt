package org.sopt.seminar_6_android.ui.kakaotv

import android.graphics.Rect
import android.icu.lang.UCharacter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import org.sopt.seminar_6_android.R
import org.sopt.seminar_6_android.databinding.FragmentRecommendChipBinding

class RecommendChipFragment : Fragment() {
    private lateinit var binding: FragmentRecommendChipBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecommendChipBinding.inflate(inflater,container,false)
        binding.rvKakaotvChannel.addItemDecoration(VerticalItemDecorator(20))



        return binding.root
    }
}