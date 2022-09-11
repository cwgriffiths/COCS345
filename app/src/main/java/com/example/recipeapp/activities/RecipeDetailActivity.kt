package com.example.recipeapp.activities

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.*
import android.text.style.BulletSpan
import android.view.Menu
import androidx.core.text.toSpannable
import com.example.recipeapp.R
import com.example.recipeapp.dao.Emojis
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
        val builder = SpannableStringBuilder()
        val newS = s.replace("[","").replace("]","");

        val ingredients = newS.split("\\")
        for (ingredient in ingredients){
            if(ingredient.trim().isNotEmpty()) {
                builder.append(
                    "${ingredient.trim()}\n\n",
                    BulletSpan(20, Color.DKGRAY, 6),
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
        val emojis = Emojis()
        binding.flag.text = if(emojis.countries.containsKey(recipe.country))
            emojis.countries[recipe.country] else emojis.countries["other"]
        binding.titleTxt.text = recipe.name.replace("(","\n(")
        binding.descriptionTxt.text = recipe.description
        binding.ingredientsTxt.text = commaStringToList(recipe.ingredients)
        binding.methodTxt.text = commaStringToList(recipe.method)
        binding.servesTxt.text = "Serves ${recipe.servings}"
    }

}
