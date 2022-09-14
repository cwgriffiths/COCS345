package com.example.recipeapp.activities

import AddMealPlannerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.recipeapp.R
import com.example.recipeapp.Util.Companion.stringToFormattedList
import com.example.recipeapp.dao.Emojis
import com.example.recipeapp.databinding.ActivityRecipeDetailBinding
import com.example.recipeapp.entities.RecipeEnt

/**
 *
 * @author Conor Griffiths
 */

class RecipeDetailActivity : AppCompatActivity() {

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


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_recipe,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.action_shopping_list -> Toast.makeText(this,"Shopping List Action Selected", Toast.LENGTH_SHORT).show()
            R.id.action_meal_planner -> AddMealPlannerDialog().show(supportFragmentManager, "AddMealPlannerDialog")
            R.id.action_settings -> Toast.makeText(this,"Settings Selected", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

    /**
     * Populate the view with the recipe data
     */
    private fun populateView() {
        val emojis = Emojis.Companion
        binding.flag.text = emojis.getEmoji(recipe.country)
        binding.titleTxt.text = recipe.name.replace("(","\n(")
        binding.descriptionTxt.text = recipe.description
        binding.ingredientsTxt.text = stringToFormattedList(recipe.ingredients)
        binding.methodTxt.text = stringToFormattedList(recipe.method)
        binding.servesTxt.text = "Serves ${recipe.servings}"
    }

}
