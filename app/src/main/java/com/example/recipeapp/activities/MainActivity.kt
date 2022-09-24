package com.example.recipeapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.recipeapp.R
//import com.example.recipeapp.RecipeFilter
import com.example.recipeapp.databinding.ActivityMainBinding
import com.example.recipeapp.ui.mealPlanner.MealPlanner
import com.example.recipeapp.ui.recipe.Recipe
import com.example.recipeapp.ui.recipe.RegionSelectNew
import com.example.recipeapp.ui.shoppingList.ShoppingList
import com.google.android.material.bottomnavigation.BottomNavigationView

/**
 * @author Conor Griffiths
 */
class MainActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    private lateinit var binding: ActivityMainBinding
    private lateinit var navBar : BottomNavigationView

    companion object {
        private var continentID: Int = -1

        /**
         * Sets the continent ID currently staged for the recipe list
         */
        fun setContinentID(id: Int) {
            continentID = id
        }
    }

    /**
     * Sets up the main activity
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        toolbar = binding.materialToolbar
        setSupportActionBar(toolbar)
        navBar = binding.bottomNavigation

        val shoppingListFragment = ShoppingList()
        val mealPlannerFragment = MealPlanner()
        val recipeSelectFragment = RegionSelectNew(supportFragmentManager)
        // Set default fragment
        setCurrentFragment(recipeSelectFragment)
        navBar.menu.findItem(R.id.recipes).isChecked = true

        // Set onSelectedListener for bottom navigation, change the displayed fragment
        navBar.setOnItemSelectedListener {
            when(it.itemId){
                R.id.shoppingList ->setCurrentFragment(shoppingListFragment)
                R.id.recipes -> onRecipeSelected()
                R.id.mealPlanner ->setCurrentFragment(mealPlannerFragment)
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
            navBar.menu.findItem(R.id.recipes).isChecked = true
            setCurrentFragment(RegionSelectNew(supportFragmentManager))
        }
    }

    /**
     * Handle recipe fragment selection
     * If continentID is set, display recipes for that continent
     * Otherwise, show the user the screen to select a continent
     */
    private fun onRecipeSelected() {
        if (continentID == -1 || supportFragmentManager.findFragmentById(R.id.fragmentContainer) is Recipe) {
            setCurrentFragment(RegionSelectNew(supportFragmentManager))
        } else {
            setCurrentFragment(Recipe(continentID))
        }
    }

    /**
     * Set the current fragment to the one passed in.
     * @param fragment The fragment to set as the current one.
     */
    private fun setCurrentFragment(fragment: Fragment) {
        toolbar.title = fragment.toString()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}