package org.sopt.seminar_6_android.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import org.sopt.seminar_6_android.R
import org.sopt.seminar_6_android.ui.view.adapter.TopViewPagerAdapter
import org.sopt.seminar_6_android.databinding.FragmentTabViewBinding
import org.sopt.seminar_6_android.ui.find.FindFragment
import org.sopt.seminar_6_android.ui.kakaotv.KakaoTVFragment

class TabViewFragment : Fragment() {
    private var _binding: FragmentTabViewBinding? = null
    private val binding get() = _binding ?: error("binding이 초기화 되지 않았습니다.")
    private lateinit var subViewPagerAdapter: TopViewPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTabViewBinding.inflate(layoutInflater, container, false)

        initSubViewPagerAdapter()
        initSubTab()

        return binding.root
    }

    private fun initSubViewPagerAdapter() {
        val fragmentList = listOf(FindFragment(), KakaoTVFragment(), EmptyFragment(), EmptyFragment())
        subViewPagerAdapter = TopViewPagerAdapter(this)
        subViewPagerAdapter.fragments.addAll(fragmentList)
        binding.vpSub.adapter = subViewPagerAdapter
    }

    private fun initSubTab() {
        val tabLabel = listOf(
            getString(R.string.find),
            getString(R.string.kakao_tv),
            getString(R.string.residual_vaccine),
            getString(R.string.covid_19)
        )

        TabLayoutMediator(binding.tlSub, binding.vpSub) { tab, position ->
            tab.text = tabLabel[position]
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}