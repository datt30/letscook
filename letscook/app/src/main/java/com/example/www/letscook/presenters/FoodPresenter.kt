package com.example.www.letscook.presenters

import com.example.www.letscook.contracts.Food
import com.example.www.letscook.models.FoodModel

/**
 * Created by David Tamayo on 01/03/2020.
 * github: datt30
 */


class FoodPresenter : Food.presenter{

    private var view : Food.view? = null
    private var model : Food.model? = null

    constructor(view: Food.view) {
        this.view = view
        this.model = FoodModel(this)
    }

    override fun showResultToView(res: String) {
        this.view?.showResult(res)
    }

    override fun knowElementFromModel(res: String) {
        this.model?.knowElement(res)
    }

}