package com.example.www.letscook.views


import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.www.letscook.R
import com.example.www.letscook.objects.RecipeDTO


class RecipeAdapter(private val context: Activity, private val recipeList: ArrayList<RecipeDTO>): BaseAdapter() {

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.recipe_item, null, true)

        val titleText = rowView.findViewById(R.id.title) as TextView
        titleText.text = recipeList[position].title

        return rowView
    }

    override fun getCount(): Int {
        return recipeList.size
    }

    override fun getItem(position: Int): Any {
        return recipeList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

}