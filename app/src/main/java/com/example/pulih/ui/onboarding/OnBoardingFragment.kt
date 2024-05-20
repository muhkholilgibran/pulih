package com.example.pulih.ui.onboarding

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.pulih.R
import com.example.pulih.response.Pages

class OnBoardingFragment(private val pages: Pages) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_on_boarding, container, false)
        view.setBackgroundColor(Color.parseColor(pages.color))
        val titleText = view.findViewById<TextView>(R.id.titleView)
        val descText = view.findViewById<TextView>(R.id.descView)
        val imageView = view.findViewById<ImageView>(R.id.imageView)

        titleText.text = pages.title
        descText.text = pages.desc
        imageView.setImageResource(pages.image)
        return view
    }


}