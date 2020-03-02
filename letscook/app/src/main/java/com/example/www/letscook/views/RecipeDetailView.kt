package com.example.www.letscook.views

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.www.letscook.R
import com.example.www.letscook.contracts_mvp.RecipeDetail
import com.example.www.letscook.objects.RecipeDTO
import com.example.www.letscook.presenters.RecipeDetailPresenter
import com.squareup.picasso.Picasso
import java.io.IOException
import java.io.InputStream


class RecipeDetailView : AppCompatActivity(), RecipeDetail.view {

    private var presenter : RecipeDetail.presenter? = null

    //view widgets declaration
    private lateinit var recipeTitle : TextView
    private lateinit var recipeImage : ImageView
    private lateinit var recipeStar1 : ImageView
    private lateinit var recipeStar2 : ImageView
    private lateinit var recipeStar3: ImageView
    private lateinit var recipeStar4: ImageView
    private lateinit var recipeStar5: ImageView
    private lateinit var recipeInstructions : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_detail_view)

        //view widgets initialize
        recipeTitle = findViewById<TextView>(R.id.recipeTitleTxt)
        recipeImage = findViewById<ImageView>(R.id.recipeImg)
        recipeStar1 = findViewById<ImageView>(R.id.star1)
        recipeStar2 = findViewById<ImageView>(R.id.star2)
        recipeStar3 = findViewById<ImageView>(R.id.star3)
        recipeStar4 = findViewById<ImageView>(R.id.star4)
        recipeStar5 = findViewById<ImageView>(R.id.star5)
        recipeInstructions = findViewById<TextView>(R.id.recipeInstructionsTxt)


        //get selected recipe id value from previous activity
        val recipeSelectedId = intent.getIntExtra("recipeId",0)

        //set the view to our presenter
        presenter = RecipeDetailPresenter(this)

        presenter!!.knowRecipeDetailFromModel(this, recipeSelectedId)
    }

    override fun showRecipeDetail(recipe: RecipeDTO) {
        recipeTitle.text = recipe.title
        Picasso.get().load(recipe.image).into(recipeImage);
        recipeInstructions.text = recipe.instructions
        showStars(recipe.rating)
    }

    //changes the stars image in agreement to rating
    fun showStars(stars: Int){
        val grayStar: Bitmap? = getBitmapFromAssetFolder("unfilled_star.png")
        val yellowStar: Bitmap? = getBitmapFromAssetFolder("fill_star.png")
        when (stars) {
            1 -> {
                    recipeStar1.setImageBitmap(yellowStar)
                    recipeStar2.setImageBitmap(grayStar)
                    recipeStar3.setImageBitmap(grayStar)
                    recipeStar4.setImageBitmap(grayStar)
                    recipeStar5.setImageBitmap(grayStar)
                 }
            2 -> {
                    recipeStar1.setImageBitmap(yellowStar)
                    recipeStar2.setImageBitmap(yellowStar)
                    recipeStar3.setImageBitmap(grayStar)
                    recipeStar4.setImageBitmap(grayStar)
                    recipeStar5.setImageBitmap(grayStar)
            }
            3 -> {
                    recipeStar1.setImageBitmap(yellowStar)
                    recipeStar2.setImageBitmap(yellowStar)
                    recipeStar3.setImageBitmap(yellowStar)
                    recipeStar4.setImageBitmap(grayStar)
                    recipeStar5.setImageBitmap(grayStar)
            }
            4 -> {
                    recipeStar1.setImageBitmap(yellowStar)
                    recipeStar2.setImageBitmap(yellowStar)
                    recipeStar3.setImageBitmap(yellowStar)
                    recipeStar4.setImageBitmap(yellowStar)
                    recipeStar5.setImageBitmap(grayStar)
            }
            5 -> {
                    recipeStar1.setImageBitmap(yellowStar)
                    recipeStar2.setImageBitmap(yellowStar)
                    recipeStar3.setImageBitmap(yellowStar)
                    recipeStar4.setImageBitmap(yellowStar)
                    recipeStar5.setImageBitmap(yellowStar)
            }
        }
    }

    @Throws(IOException::class)
    private fun getBitmapFromAssetFolder(strName: String): Bitmap? {
        val assetManager = assets
        val inpStream: InputStream = assetManager.open(strName)
        return BitmapFactory.decodeStream(inpStream)
    }

}
