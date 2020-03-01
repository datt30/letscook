package com.example.www.letscook.models

/**
 * Created by David Tamayo on 01/03/2020.
 * github: datt30
 */

import android.content.Context
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.www.letscook.contracts.Recipe
import com.example.www.letscook.objects.RecipeDTO
import com.example.www.letscook.views.RecipeAdapter
import org.json.JSONArray


class RecipeModel : Recipe.model {

    private var presenter : Recipe.presenter? = null
    private var dataElement : String = ""

    constructor(presenter : Recipe.presenter){
        this.presenter = presenter
    }

    override fun knowRecipes(context : Context) {
        //list of recipes that will be return
        var recipesList = ArrayList<RecipeDTO>()

        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(context)
        val url: String = "https://gl-endpoint.herokuapp.com/recipes/"

        // Request a string response from the provided URL.
        val stringReq = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->
                val recipes: JSONArray = JSONArray(response.toString())
                for (i in 0 until recipes.length()) {
                    val recipeItemJson = recipes.getJSONObject(i)
                    recipesList.add(
                        RecipeDTO(
                            recipeItemJson.get("id") as Int,
                            recipeItemJson.get("title") as String
                        )
                    )
                }
                //call presenter to show in view the recipes results
                presenter!!.showRecipesToView(recipesList)

            },
            Response.ErrorListener { })
        queue.add(stringReq)
    }



}