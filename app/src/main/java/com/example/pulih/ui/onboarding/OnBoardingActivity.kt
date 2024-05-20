package com.example.pulih.ui.onboarding

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.pulih.R
import com.example.pulih.adapter.OnBoardingAdapter
import com.example.pulih.databinding.ActivityOnBoardingBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.example.pulih.response.Pages
import com.example.pulih.ui.main.MainActivity
import com.example.pulih.util.gone
import com.example.pulih.util.visible


class OnBoardingActivity : AppCompatActivity(){

    private lateinit var pagerList : ArrayList<Pages>
    private lateinit var binding: ActivityOnBoardingBinding
    private lateinit var onBoardingViewPager2 : ViewPager2
    private lateinit var skipBtn : Button
    private lateinit var nextBtn : Button
    private lateinit var prevBtn : Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onBoardingViewPager2 = findViewById(R.id.viewPager)
        skipBtn = findViewById(R.id.skipBtn)
        nextBtn = findViewById(R.id.nextBtn)
        prevBtn = findViewById(R.id.previousBtn)

        pagerList = arrayListOf(
            Pages(getString(R.string.screenTitle1),
                R.drawable.screen1,getString(R.string.screenDescription1),"#FFE838"),
            Pages(getString(R.string.screenTitle2),
                R.drawable.screen2,getString(R.string.screenDescription2),"#FFE838"),
            Pages(getString(R.string.screenTitle3),
                R.drawable.screen3,getString(R.string.screenDescription3),"#FFE838"),
            Pages(getString(R.string.screenTitle4),
                R.drawable.screen4,getString(R.string.screenDescription4),"#FFE838")
        )

        onBoardingViewPager2.apply {
            adapter = OnBoardingAdapter(this@OnBoardingActivity,pagerList)
            registerOnPageChangeCallback(onBoardingPageChangeCallback)
            (getChildAt(0) as RecyclerView).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        }

        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        TabLayoutMediator(tabLayout,onBoardingViewPager2){ _, _ -> }.attach()

        nextBtn.setOnClickListener{
            if (onBoardingViewPager2.currentItem < onBoardingViewPager2.adapter!!.itemCount -1){
                onBoardingViewPager2.currentItem += 1
            } else{
                homeScreenIntent()
            }

        }

        skipBtn.setOnClickListener{
            homeScreenIntent()
        }

        prevBtn.setOnClickListener{
            if (onBoardingViewPager2.currentItem > 0){
                onBoardingViewPager2.currentItem -=1
            }
        }
    }

    override fun onDestroy() {
        onBoardingViewPager2.unregisterOnPageChangeCallback(onBoardingPageChangeCallback)
        super.onDestroy()
    }

    private fun homeScreenIntent() {
        val homeIntent = Intent(this, MainActivity::class.java)
        startActivity(homeIntent)
    }

    private val onBoardingPageChangeCallback = object : ViewPager2.OnPageChangeCallback(){
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            when(position){
                0 -> {
                    skipBtn.visible()
                    nextBtn.visible()
                    prevBtn.gone()
                }
                1-> {
                    skipBtn.visible()
                    nextBtn.visible()
                    prevBtn.visible()
                }
                2-> {
                    skipBtn.visible()
                    nextBtn.visible()
                    nextBtn.text = "Next"
                    prevBtn.visible()
                }
                3-> {
                    skipBtn.gone()
                    nextBtn.visible()
                    nextBtn.text = "Start"
                    prevBtn.visible()
                }
            }

        }

    }

}