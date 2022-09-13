package com.example.recipeapp.activities

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.recipeapp.R
//import com.example.recipeapp.RecipeFilter
import com.example.recipeapp.databinding.ActivityMainBinding
import com.example.recipeapp.fragments.*

/**
 * @author Conor Griffiths
 */

class MainActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    private lateinit var binding: ActivityMainBinding

    companion object {
        private var continentID: Int = -1

        fun setContinentID(id: Int) {
            continentID = id
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        toolbar = binding.materialToolbar
        setSupportActionBar(toolbar)
        val navBar = binding.bottomNavigation

        val shoppingListFragment = ShoppingList()
        val mealPlannerFragment = MealPlanner()
        val recipeSelectFragment = RegionSelectNew(supportFragmentManager)
        // Set default fragment
        setFragment(recipeSelectFragment)
        navBar.menu.findItem(R.id.recipes).isChecked = true

//        RecipeFilter.setup(this.applicationContext)
//        println(RecipeFilter.getRecipesWithIngredients(listOf(1,2,3,29)))

        // Set onSelectedListener for bottom navigation, change the displayed fragment
        navBar.setOnItemSelectedListener {
            when(it.itemId){
                R.id.shoppingList ->setFragment(shoppingListFragment)
                R.id.recipes -> onRecipeSelected()
                R.id.mealPlanner ->setFragment(mealPlannerFragment)
            }
            true
        }

    }


    /**
     * If the back button is pressed the user is taken to the recipe select fragment
     * If the user is on the recipe select fragment and presses the back button the app is closed
     */
    override fun onBackPressed() {
        if(supportFragmentManager.findFragmentById(R.id.fragmentContainer) is RegionSelectNew){
            super.onBackPressed()
        } else {
            continentID = -1
            setFragment(RegionSelectNew(supportFragmentManager))
        }
    }

    /**
     * Handle recipe fragment selection
     * If continentID is set, display recipes for that continent
     * Otherwise, show the user the screen to select a continent
     */
    private fun onRecipeSelected() {
        if (continentID == -1 || supportFragmentManager.findFragmentById(R.id.fragmentContainer) is Recipe) {
            setFragment(RegionSelectNew(supportFragmentManager))
        } else {
            setFragment(Recipe(continentID))
        }
    }


/*    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_recipe,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.action_shopping_list -> Toast.makeText(this,"Shopping List Action Selected",Toast.LENGTH_SHORT).show()
            R.id.action_meal_planner -> Toast.makeText(this,"Meal Planner Action Selected",Toast.LENGTH_SHORT).show()
            R.id.action_settings -> Toast.makeText(this,"Settings Selected",Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }*/

    /**Set the current fragment to the one passed in.
     * @param fragment The fragment to set as the current one.
     */
    private fun setFragment(fragment: Fragment) {
        toolbar.title = fragment.toString()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}