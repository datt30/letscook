package com.example.www.letscook.models

/**
 * Created by David Tamayo on 01/03/2020.
 * github: datt30
 */

import com.example.www.letscook.contracts.Recipe


class RecipeModel : Recipe.model {

    private var presenter : Recipe.presenter? = null
    private var dataElement : String = ""

    constructor(presenter : Recipe.presenter){
        this.presenter = presenter
    }

    override fun knowElement(res: String) {  //json, xml, all data what you want to retrieve to the view
        dataElement = "add and Save Element:$res"
        presenter!!.showResultToView(dataElement)
    }

}