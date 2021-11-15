package org.sopt.seminar_6_android.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import org.sopt.seminar_6_android.R
import org.sopt.seminar_6_android.ui.view.adapter.TopViewPagerAdapter
import org.sopt.seminar_6_android.databinding.FragmentViewBinding

class ViewFragment : Fragment() {
    private var _binding: FragmentViewBinding? = null
    private val binding get() = _binding ?: error("binding이 초기화 되지 않았습니다.")
    private lateinit var topViewPagerAdapter: TopViewPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentViewBinding.inflate(layoutInflater, container, false)

        initTopViewPagerAdapter()
        initTopTab()
        return binding.root
    }

    private fun initTopViewPagerAdapter() {
        val fragmentList = listOf(TabViewFragment(), TabMyViewFragment())
        topViewPagerAdapter = TopViewPagerAdapter(this)
        topViewPagerAdapter.fragments.addAll(fragmentList)
        binding.vpTop.adapter = topViewPagerAdapter
    }

    private fun initTopTab() {
        val tabLabel = listOf(getString(R.string.view), getString(R.string.my_view))

        TabLayoutMediator(binding.tlMain, binding.vpTop) { tab, position ->
            tab.text = tabLabel[position]
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}