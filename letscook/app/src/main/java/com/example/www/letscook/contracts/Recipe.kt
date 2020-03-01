package com.example.www.letscook.contracts

import android.content.Context
import com.example.www.letscook.objects.RecipeDTO


/**
 * Created by David Tamayo on 01/03/2020.
 * github: datt30
 */

//Our contracts are a good way to follow the implementation of our architecture.
// we will define here all those functions that we will need for each of our mvp layers and retrieve our recipes.
interface Recipe {

    interface view{
        fun showRecipes(recipesList : ArrayList<RecipeDTO>)
    }

    interface presenter{
        fun showRecipesToView(recipesList : ArrayList<RecipeDTO>)
        fun knowRecipesFromModel(context : Context)
    }

    interface model{
        fun knowRecipes(context : Context)
    }

}