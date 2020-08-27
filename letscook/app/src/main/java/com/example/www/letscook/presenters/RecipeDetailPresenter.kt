package com.example.www.letscook.presenters

import android.content.Context
import com.example.www.letscook.contracts_mvp.RecipeDetail
import com.example.www.letscook.models.RecipeDetailModel
import com.example.www.letscook.objects.RecipeDTO

/**
 * Created by David Tamayo on 01/03/2020.
 * github: datt30
 */


class RecipeDetailPresenter : RecipeDetail.presenter{

    private var view : RecipeDetail.view? = null
    private var model : RecipeDetail.model? = null

    constructor(view: RecipeDetail.view) {
        this.view = view
        this.model = RecipeDetailModel(this)
    }

    override fun showRecipeDetailToView(recipe: RecipeDTO) {
        this.view?.showRecipeDetail(recipe)
    }

    override fun knowRecipeDetailFromModel(context: Context, recipeId: Int) {
        this.model?.knowRecipeDetail(context,recipeId)
    }

}