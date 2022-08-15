package com.example.recipeapp.activities

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.*
import android.text.style.BulletSpan
import android.view.Menu
import androidx.core.text.toSpannable
import com.example.recipeapp.R
import com.example.recipeapp.databinding.ActivityRecipeDetailBinding
import com.example.recipeapp.entities.RecipeEnt

/**
 *
 * @author Conor Griffiths
 */

class RecipeDetailActivity() : AppCompatActivity() {

    private lateinit var recipe: RecipeEnt
    private lateinit var binding : ActivityRecipeDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        recipe = intent.getParcelableExtra("recipe")!!
        binding = ActivityRecipeDetailBinding.inflate(layoutInflater)

        val toolbar = binding.materialToolbar
        toolbar.title = recipe.name
        setSupportActionBar(toolbar)

        setContentView(binding.root)
        populateView()


    }

    /**
     * Take a comma separated string and return a string formatted with bullet points and new lines
     */
    private fun commaStringToList(s: String): Spannable {
       // var st = s.replace(".", ",")
        val builder = SpannableStringBuilder()
        val ingredients = s.split("\\")
        for (ingredient in ingredients){
            if(ingredient.trim().isNotEmpty()) {
                builder.append(
                    "${ingredient.trim()}\n",
                    BulletSpan(40, Color.DKGRAY, 10),
                    SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE
                )
            }
        }
        return builder.toSpannable()
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    /**
     * Populate the view with the recipe data
     */
    private fun populateView() {
        binding.titleTxt.text = recipe.name
        binding.descriptionTxt.text = recipe.description
        binding.ingredientsTxt.text = commaStringToList(recipe.ingredients)
        binding.methodTxt.text = commaStringToList(recipe.method)
        binding.servesTxt.text = "Serves ${recipe.servings}"
    }

}
