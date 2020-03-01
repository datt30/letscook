package com.example.www.letscook.presenters

import com.example.www.letscook.contracts.Recipe
import com.example.www.letscook.models.RecipeModel

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

    override fun showResultToView(res: String) {
        this.view?.showResult(res)
    }

    override fun knowElementFromModel(res: String) {
        this.model?.knowElement(res)
    }

}