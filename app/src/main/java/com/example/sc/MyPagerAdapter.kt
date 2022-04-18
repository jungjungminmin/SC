package com.example.sc

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter



class MyPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    private val NUM_PAGES = 3

    override fun getItemCount(): Int = NUM_PAGES

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                TypeDramaFragment.newInstance("Page1", "")
            }
            1 -> {
                TypeMovieFragment.newInstance("Page2", "")
            }
            else -> {
                TypeRestFragment.newInstance("Page3", "")
            }
        }
    }
}