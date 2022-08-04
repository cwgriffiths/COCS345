package com.example.recipeapp

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar = findViewById(R.id.materialToolbar)
        setSupportActionBar(toolbar)
        val navBar = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        val shoppingListFragment = ShoppingList()
        val mealPlannerFragment = MealPlanner()
        val recipeFragment = Recipe()


        // Set default fragment
        setFragment(recipeFragment)
        navBar.menu.findItem(R.id.recipes).isChecked = true

        // Set onSelectedListener for bottom navigation, change the displayed fragment
        navBar.setOnItemSelectedListener {
            when(it.itemId){
                R.id.shoppingList->setFragment(shoppingListFragment)
                R.id.recipes->setFragment(recipeFragment)
                R.id.mealPlanner->setFragment(mealPlannerFragment)
            }
            true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
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