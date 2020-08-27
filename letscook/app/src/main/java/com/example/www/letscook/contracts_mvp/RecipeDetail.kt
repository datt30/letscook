package com.example.www.letscook.contracts_mvp

import android.content.Context
import com.example.www.letscook.objects.RecipeDTO


/**
 * Created by David Tamayo on 01/03/2020.
 * github: datt30
 */

//Our contracts are a good way to follow the implementation of our architecture.
// we will define here all those functions that we will need for each of our mvp layers and retrieve our recipes.
interface RecipeDetail {

    interface view{
        fun showRecipeDetail(recipe : RecipeDTO)
    }

    interface presenter{
        fun showRecipeDetailToView(recipe : RecipeDTO)
        fun knowRecipeDetailFromModel(context : Context, recipeId : Int)
    }

    interface model{
        fun knowRecipeDetail(context : Context, recipeId : Int)
    }

}