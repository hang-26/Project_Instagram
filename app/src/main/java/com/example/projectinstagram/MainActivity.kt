package com.example.projectinstagram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.replace
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.widget.ViewPager2
import com.example.projectinstagram.databinding.ActivityMainBinding
import com.example.projectinstagram.fragment.FragmentAdapter
import com.example.projectinstagram.fragment.HomeFragment
import com.example.projectinstagram.fragment.SearchFragment
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var adapter: FragmentAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = FragmentAdapter(supportFragmentManager, lifecycle)
        setViewPager2()
        setEventOnclick()

    }

    private fun setViewPager2() {
        binding.vpViewActivity.adapter = adapter
        binding.vpViewActivity.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback()
        {
            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> binding.bnvView.menu.findItem(R.id.item_home).setChecked(true)
                    1 -> binding.bnvView.menu.findItem(R.id.item_search).setChecked(true)
                    2 -> binding.bnvView.menu.findItem(R.id.item_add).setChecked(true)
                    3 -> binding.bnvView.menu.findItem(R.id.item_video).setChecked(true)
                    else -> binding.bnvView.menu.findItem(R.id.item_user).setChecked(true)
                }
            }
            }
        )
    }


    private fun setEventOnclick() {
        binding.bnvView.setOnItemSelectedListener(NavigationBarView.OnItemSelectedListener {
            when (it.itemId) {
                R.id.item_home -> binding.vpViewActivity.setCurrentItem(0)
                R.id.item_search -> binding.vpViewActivity.setCurrentItem(1)
                R.id.item_add -> binding.vpViewActivity.setCurrentItem(2)
                R.id.item_video -> binding.vpViewActivity.setCurrentItem(3)
                else -> binding.vpViewActivity.setCurrentItem(4)
            }
            return@OnItemSelectedListener true
        })
    }

}