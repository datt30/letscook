package com.example.www.letscook.views

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.www.letscook.R
import com.example.www.letscook.contracts.Recipe
import com.example.www.letscook.objects.RecipeDTO
import com.example.www.letscook.presenters.RecipePresenter

import org.json.JSONArray


class RecipeView : AppCompatActivity(), Recipe.view{

    private var presenter : Recipe.presenter? = null
    private lateinit var recipelistView : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_view)

        //set the view to our presenter
        presenter = RecipePresenter(this)

        recipelistView = findViewById<ListView>(R.id.recipesListView)
        recipelistView.setOnItemClickListener(){adapterView, view, position, id ->
            val selectedRecipe = adapterView.getItemAtPosition(position) as RecipeDTO
            val intent = Intent(this, RecipeDetailView::class.java)
            intent.putExtra("recipeId",selectedRecipe.id)
            startActivity(intent)
        }
        //call our presenter to retrieve the list of recipes to show it in view
        getRecipes()
    }

    //our presenter call a method (definite in the interface contract like "knowElementFromModel")
    // to interact with the model and then retrieves in this case our recipes
    fun getRecipes() {
        presenter!!.knowRecipesFromModel(this)
    }

    //this function is called when the presenter needs show up some data in the current layout from this view
    override fun showRecipes(recipesList: ArrayList<RecipeDTO>) {
        val recipeAdapter = RecipeAdapter(this, recipesList)
        recipelistView.adapter = recipeAdapter
    }



}
