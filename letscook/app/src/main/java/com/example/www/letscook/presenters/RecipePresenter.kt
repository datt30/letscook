package com.example.www.letscook.presenters

import android.content.Context
import com.example.www.letscook.contracts_mvp.Recipe
import com.example.www.letscook.models.RecipeModel
import com.example.www.letscook.objects.RecipeDTO

/**
 * Created by David Tamayo on 01/03/2020.
 * github: datt30
 */


class RecipePresenter : Recipe.presenter{

    private var view : Recipe.view? = null
    private var model : Recipe.model? = null

    constructor(view: Recipe.view) {
        this.view = view
        this.model = RecipeModel(this)
    }

    override fun showRecipesToView(recipesList : ArrayList<RecipeDTO>) {
        this.view?.showRecipes(recipesList)
    }

    override fun knowRecipesFromModel(context : Context) {
        this.model?.knowRecipes(context)
    }

}