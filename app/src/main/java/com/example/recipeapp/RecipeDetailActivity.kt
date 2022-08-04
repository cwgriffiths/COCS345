package com.example.recipeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import com.example.recipeapp.databinding.ActivityRecipeDetailBinding
import com.example.recipeapp.entities.RecipeEnt

class RecipeDetailActivity() : AppCompatActivity() {

    private lateinit var recipe: RecipeEnt
    private lateinit var binding : ActivityRecipeDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        recipe = intent.getParcelableExtra("recipe")!!
        binding = ActivityRecipeDetailBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.titleTxt.text = recipe.name
        binding.descriptionTxt.text = recipe.description
        binding.ingredientsTxt.text = commaStringToList(recipe.ingredients)
        binding.methodTxt.text = commaStringToList(recipe.method)
        binding.servesTxt.text = "Serves ${recipe.servings}"
    }

    /**
     * Take a comma separated string and return a string formatted with bullet points and new lines
     */
    private fun commaStringToList(s: String): String{
        var st = s.replace(".", ",")
        val builder = StringBuilder()
        val ingredients = st.split(",")
        for (ingredient in ingredients){
            builder.append("• \t\t${ingredient.trim()}\n")
        }
        return builder.toString()
    }

    /**
     * Populate the view with the recipe data
     */
    private fun populateView() {

    }

}