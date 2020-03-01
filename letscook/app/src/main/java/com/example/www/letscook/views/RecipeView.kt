package com.example.www.letscook.views

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.www.letscook.R
import com.example.www.letscook.contracts.Recipe
import com.example.www.letscook.presenters.RecipePresenter
import org.json.JSONArray


class RecipeView : AppCompatActivity(), Recipe.view{

    private var presenter : Recipe.presenter? = null
    lateinit var txtElement : TextView
    lateinit var editTextElement : EditText
    private lateinit var recipelistView : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_view)

        //txtElement = findViewById(R.id.txtElement)
        //editTextElement = findViewById(R.id.editTextElement)

        //set the view to our presenter
        presenter = RecipePresenter(this)


        recipelistView = findViewById<ListView>(R.id.recipesListView)
        var listItems = arrayOf("food1","food2")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems)
        recipelistView.adapter = adapter

        getRecipes()
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

    fun getRecipes(){
        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
        val url: String = "https://gl-endpoint.herokuapp.com/recipes/"

        // Request a string response from the provided URL.
        val stringReq = StringRequest(Request.Method.GET, url,
            Response.Listener<String> { response ->
                var strResp = response.toString()
                val jsonArray: JSONArray = JSONArray(strResp)
                Toast.makeText(this,strResp,Toast.LENGTH_LONG).show()
            },
            Response.ErrorListener { Toast.makeText(this,"error response",Toast.LENGTH_LONG).show() })
        //Response.ErrorListener { textView!!.text = "That didn't work!" })
        queue.add(stringReq)
    }


}
