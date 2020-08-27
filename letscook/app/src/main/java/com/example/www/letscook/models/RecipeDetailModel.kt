package com.example.www.letscook.models

/**
 * Created by David Tamayo on 01/03/2020.
 * github: datt30
 */

import android.content.Context
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.www.letscook.contracts.RecipeDetail
import com.example.www.letscook.objects.RecipeDTO
import org.json.JSONArray
import org.json.JSONObject


class RecipeDetailModel : RecipeDetail.model {

    private var presenter : RecipeDetail.presenter? = null

    constructor(presenter : RecipeDetail.presenter){
        this.presenter = presenter
    }

    override fun knowRecipeDetail(context: Context, recipeId: Int) {
        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(context)
        val url: String = "https://gl-endpoint.herokuapp.com/recipes/$recipeId"

        // Request a string response from the provided URL.
        val stringReq = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->
                val recipeItemJson = JSONObject(response)
                val recipe = RecipeDTO(
                    recipeItemJson.get("id") as Int,
                    recipeItemJson.get("title") as String,
                    recipeItemJson.get("rating") as Int,
                    recipeItemJson.get("image") as String,
                    recipeItemJson.get("instructions") as String
                )
                //call presenter to show in view the recipe detail result
                presenter!!.showRecipeDetailToView(recipe)
            },
            Response.ErrorListener { })
        queue.add(stringReq)
    }


}