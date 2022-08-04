package com.example.recipeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recipeapp.entities.RecipeEnt

class RecipeDetailActivity() : AppCompatActivity() {

    private lateinit var recipe: RecipeEnt


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_detail)
        recipe = intent.getParcelableExtra("recipe")!!



    }

    /**
     * Populate the view with the recipe data
     */
    private fun populateView() {

    }

}