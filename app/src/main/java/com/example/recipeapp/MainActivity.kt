package com.example.recipeapp

import android.os.Bundle
import androidx.activity.viewModels
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.recipeapp.databinding.ActivityMainBinding
import com.example.recipeapp.db.entities.RecipeEnt
import com.example.recipeapp.ui.mealPlanner.MealPlannerViewModel
import com.example.recipeapp.ui.recipe.RecipeViewModel
import com.example.recipeapp.ui.shoppingList.ShoppingListViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    private val recipeViewModel: RecipeViewModel by viewModels { RecipeViewModel.Factory }
    private val shoppingListViewModel: ShoppingListViewModel by viewModels { ShoppingListViewModel.Factory }
    private val mealPlannerViewModel: MealPlannerViewModel by viewModels { MealPlannerViewModel.Factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment
        navController = navHostFragment.findNavController()
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.regionSelectFragment, R.id.mealPlannerFragment, R.id.shoppingListFragment
            )
        )
        setSupportActionBar(binding.toolbar)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        shoppingListViewModel.items.observeForever { println() }
        mealPlannerViewModel.items.observeForever {}

//        seeRecipes(recipeViewModel.getRecipes())
    }

    override fun onStart() {
        super.onStart()
        recipeViewModel.getRecipes()
        shoppingListViewModel.items.removeObservers(this)
        mealPlannerViewModel.items.removeObservers(this)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    fun seeRecipes(recipes: List<RecipeEnt>) {
        val catmap = HashMap<String, Int>()
        val metricmap = HashMap<String, Int>()
        val namemap = HashMap<String, Int>()
        recipes.forEach {
            val ingredientList = it.recipeShopping.split(",")
            if (ingredientList.size % 4 != 0) {
                println("Recipe id " + it.name)
            } else {
                for (i in ingredientList.indices step 4) {
                    val cat = ingredientList[i + 2].trim().lowercase()
                    val metric = ingredientList[i + 1].trim().lowercase()
                    val name = ingredientList[i + 3].trim().lowercase()
                    if (catmap.containsKey(cat)) {
                        catmap[cat]!!.plus(1)
                    } else {
                        catmap[cat] = 1
                    }

                    if (namemap.containsKey(name)) {
                        namemap[name]!!.plus(1)
                    } else {
                        namemap[name] = 1
                    }

                    if (metricmap.containsKey(metric)) {
                        metricmap[metric]!!.plus(1)
                    } else {
                        metricmap[metric] = 1
                    }
                }
            }
        }
        println(namemap.keys.sorted())
//        println(metricmap)
//        println(catmap)
    }
}