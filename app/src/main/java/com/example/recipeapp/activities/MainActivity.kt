package com.example.recipeapp.activities

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.recipeapp.fragments.MealPlanner
import com.example.recipeapp.R
import com.example.recipeapp.fragments.Recipe
import com.example.recipeapp.fragments.ShoppingList
import com.example.recipeapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        toolbar = binding.materialToolbar
        setSupportActionBar(toolbar)
        val navBar = binding.bottomNavigation

        val shoppingListFragment = ShoppingList()
        val mealPlannerFragment = MealPlanner()
        val recipeFragment = Recipe()
        // Set default fragment
        setFragment(recipeFragment)
        navBar.menu.findItem(R.id.recipes).isChecked = true

        RecipeFilter.setup(this.applicationContext)
        RecipeFilter.test()

        // Set onSelectedListener for bottom navigation, change the displayed fragment
        navBar.setOnItemSelectedListener {
            when(it.itemId){
                R.id.shoppingList ->setFragment(shoppingListFragment)
                R.id.recipes ->setFragment(recipeFragment)
                R.id.mealPlanner ->setFragment(mealPlannerFragment)
            }
            true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        return true
    }

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