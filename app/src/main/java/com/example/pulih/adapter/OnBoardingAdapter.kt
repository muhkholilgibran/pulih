package com.example.pulih.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.pulih.ui.onboarding.OnBoardingFragment
import com.example.pulih.response.Pages

class OnBoardingAdapter(activity: FragmentActivity, private val pagerList : ArrayList<Pages>): FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return pagerList.size
    }

    override fun createFragment(position: Int): Fragment {
        return OnBoardingFragment(pagerList[position])
    }


}