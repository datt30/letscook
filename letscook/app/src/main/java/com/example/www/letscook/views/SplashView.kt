package com.example.www.letscook.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.www.letscook.R

class SplashView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_view)

        val intent = Intent(this, FoodView::class.java)
        startActivity(intent)
        finish()
    }
}
