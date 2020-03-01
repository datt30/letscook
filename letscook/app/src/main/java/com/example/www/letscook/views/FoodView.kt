package com.example.www.letscook.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.example.www.letscook.R
import com.example.www.letscook.contracts.Food
import com.example.www.letscook.presenters.FoodPresenter

class FoodView : AppCompatActivity(), Food.view{

    private var presenter : Food.presenter? = null
    lateinit var txtElement : TextView
    lateinit var editTextElement : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_view)

        //txtElement = findViewById(R.id.txtElement)
        //editTextElement = findViewById(R.id.editTextElement)

        //set the view to our presenter
        presenter = FoodPresenter(this)
    }

    //our presenter call a method (definite in the interface contract like "knowElementFromModel")
    // to interact with the model and then retrieves the data
    fun saveDataToElement(view: View) {
        presenter!!.knowElementFromModel(editTextElement.text.toString())
    }

    //this function is called when the presenter needs show up some data in the current layout from this view
    override fun showResult(res: String) {
        txtElement.text = res
    }


}
