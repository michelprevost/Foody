package com.example.foody.ui.fragments.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import coil.load
import com.example.foody.R
import com.example.foody.models.Result
import kotlinx.android.synthetic.main.fragment_overview.view.*
import org.jsoup.Jsoup

class OverviewFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_overview, container, false)

        val args = arguments
        val myBundle: Result? = args?.getParcelable("recipeBundle")

        myBundle?.let {
            view.main_imageView.load(myBundle.image)
            view.title_textView.text = myBundle.title
            view.likes_textView.text = myBundle.readyInMinutes.toString()
            view.time_textView.text = myBundle.readyInMinutes.toString()
            myBundle.summary.let {
                view.summary_textView.text = Jsoup.parse(it).text()
            }

            val greenColor = ContextCompat.getColor(requireContext(), R.color.green)

            if (myBundle.vegetarian) {
                view.vegetarian_imageView.setColorFilter(greenColor)
                view.vegetarian_textView.setTextColor(greenColor)
            }

            if (myBundle.vegan) {
                view.vegan_imageView.setColorFilter(greenColor)
                view.vegan_textView.setTextColor(greenColor)
            }

            if (myBundle.glutenFree) {
                view.gluten_free_imageView.setColorFilter(greenColor)
                view.gluten_free_textView.setTextColor(greenColor)
            }

            if (myBundle.dairyFree) {
                view.dairy_free_imageView.setColorFilter(greenColor)
                view.dairy_free_textView.setTextColor(greenColor)
            }

            if (myBundle.veryHealthy) {
                view.healthy_imageView.setColorFilter(greenColor)
                view.healthy_textView.setTextColor(greenColor)
            }

            if (myBundle.cheap) {
                view.cheap_imageView.setColorFilter(greenColor)
                view.cheap_textView.setTextColor(greenColor)
            }
        }

        return view
    }
}