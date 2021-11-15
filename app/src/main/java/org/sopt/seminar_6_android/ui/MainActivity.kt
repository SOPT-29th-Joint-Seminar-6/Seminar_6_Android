package org.sopt.seminar_6_android.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import org.sopt.seminar_6_android.R
import org.sopt.seminar_6_android.adapter.MainViewPagerAdapter
import org.sopt.seminar_6_android.databinding.ActivityMainBinding
import org.sopt.seminar_6_android.ui.view.EmptyFragment
import org.sopt.seminar_6_android.ui.view.ViewFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var mainViewPagerAdapter: MainViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        initSelectMenu()
        initMainViewPagerAdapter()
        initBottomNavigation()

        setContentView(binding.root)
    }

    private fun initSelectMenu() {
        binding.bnMain.selectedItemId = VIEW_FRAGMENT
        binding.bnMain.menu.getItem(VIEW_FRAGMENT).isChecked = true
    }

    private fun initMainViewPagerAdapter() {
        val fragmentList = listOf(EmptyFragment(), EmptyFragment(), ViewFragment(), EmptyFragment(), EmptyFragment())

        mainViewPagerAdapter = MainViewPagerAdapter(this)
        mainViewPagerAdapter.fragments.addAll(fragmentList)
        binding.vpMain.adapter = mainViewPagerAdapter
        binding.vpMain.currentItem = VIEW_FRAGMENT
    }

    private fun initBottomNavigation() {
        binding.vpMain.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                binding.bnMain.menu.getItem(position).isChecked = true
            }
        })

        binding.bnMain.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.menu_person -> {
                    binding.vpMain.currentItem = PERSON_FRAGMENT
                    return@setOnItemSelectedListener  true
                }
                R.id.menu_communicate -> {
                    binding.vpMain.currentItem = COMMU_FRAGMENT
                    return@setOnItemSelectedListener true
                }
                R.id.menu_view -> {
                    binding.vpMain.currentItem = VIEW_FRAGMENT
                    return@setOnItemSelectedListener  true
                }
                R.id.menu_store -> {
                    binding.vpMain.currentItem = STORE_FRAGMENT
                    return@setOnItemSelectedListener true
                }
                else -> {
                    binding.vpMain.currentItem = MORE_FRAGMENT
                    return@setOnItemSelectedListener true
                }
            }
        }
    }

    companion object {
        val PERSON_FRAGMENT = 0
        val COMMU_FRAGMENT = 1
        val VIEW_FRAGMENT = 2
        val STORE_FRAGMENT = 3
        val MORE_FRAGMENT = 4
    }
}