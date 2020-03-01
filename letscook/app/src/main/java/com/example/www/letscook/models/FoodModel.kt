package com.example.www.letscook.models

/**
 * Created by David Tamayo on 01/03/2020.
 * github: datt30
 */

import com.example.www.letscook.contracts.Food


class FoodModel : Food.model {

    private var presenter : Food.presenter? = null
    private var dataElement : String = ""

    constructor(presenter : Food.presenter){
        this.presenter = presenter
    }

    override fun knowElement(res: String) {  //json, xml, all data what you want to retrieve to the view
        dataElement = "add and Save Element:$res"
        presenter!!.showResultToView(dataElement)
    }

}