package org.sopt.seminar_6_android.ui.kakaotv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.sopt.seminar_6_android.databinding.FragmentKakaoTVBinding

class KakaoTVFragment : Fragment() {
    private var _binding: FragmentKakaoTVBinding? = null
    private val binding get() = _binding ?: error("binding이 초기화 되지 않았습니다.")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentKakaoTVBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}