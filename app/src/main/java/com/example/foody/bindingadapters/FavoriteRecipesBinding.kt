package com.example.foody.bindingadapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.foody.adapters.FavoriteRecipesAdapter
import com.example.foody.data.database.entities.FavoritesEntity

class FavoriteRecipesBinding {

    companion object {

        @BindingAdapter("viewVisibility", "setData", requireAll = false)
        @JvmStatic
        fun setDataAndViewVisibility(
            view: View,
            favoriteEntities: List<FavoritesEntity>?,
            adapter: FavoriteRecipesAdapter?
        ) {
            var displayList = true
            if (favoriteEntities.isNullOrEmpty()) {
                displayList = false
            } else {
                adapter?.setData(favoriteEntities)
            }

            when (view) {
                is ImageView -> {
                    view.visibility = if (displayList) View.INVISIBLE else View.VISIBLE
                }

                is TextView -> {
                    view.visibility = if (displayList) View.INVISIBLE else View.VISIBLE
                }

                is RecyclerView -> {
                    view.visibility = if (displayList) View.VISIBLE else View.INVISIBLE
                }
            }
        }

    }

}