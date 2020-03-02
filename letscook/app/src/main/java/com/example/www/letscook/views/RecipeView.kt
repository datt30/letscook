package com.example.www.letscook.views

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.www.letscook.R
import com.example.www.letscook.adapters.RecipeAdapter
import com.example.www.letscook.contracts_mvp.Recipe
import com.example.www.letscook.objects.RecipeDTO
import com.example.www.letscook.presenters.RecipePresenter


class RecipeView : AppCompatActivity(), Recipe.view{

    private var presenter : Recipe.presenter? = null

    private var recipesList: ArrayList<RecipeDTO>? = null
    private var recipeAdapter : RecipeAdapter? = null

    private lateinit var recipeSearchView: SearchView
    private lateinit var recipeListView : ListView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_view)

        //set the view to our presenter
        presenter = RecipePresenter(this)


        //search bar logic /////////////////////////////////////////////
        recipeSearchView = findViewById<SearchView>(R.id.searchBar)
        recipeSearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(searchText: String): Boolean {
                var recipesListFiltered = ArrayList<RecipeDTO>()
                if(searchText == ""){
                    getRecipes()
                }
                for (recipe in recipesList!!){
                    if (searchText.toLowerCase() in recipe.title.toLowerCase()){
                        recipesListFiltered.add(recipe)
                    }
                }
                showRecipes(recipesListFiltered)
                return true
            }
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

        })

        //listView for recipes logic/////////////////////////////////////////////
        recipeListView = findViewById<ListView>(R.id.recipesListView)
        recipeListView.setOnItemClickListener(){adapterView, view, position, id ->
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
        this.recipesList = recipesList
        recipeAdapter = RecipeAdapter(this, this.recipesList!!)
        recipeListView.adapter = recipeAdapter
    }



}
