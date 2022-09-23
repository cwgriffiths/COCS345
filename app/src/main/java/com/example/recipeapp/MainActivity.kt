package com.example.recipeapp

import android.os.Bundle
import androidx.activity.viewModels
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.recipeapp.databinding.ActivityMainBinding
import com.example.recipeapp.db.entities.RecipeEnt
import com.example.recipeapp.ui.recipe.RecipeViewModel
import com.example.recipeapp.ui.shoppingList.ShoppingListViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    private val recipeViewModel: RecipeViewModel by viewModels { RecipeViewModel.Factory}
    private val shoppingListViewModel: ShoppingListViewModel by viewModels { ShoppingListViewModel.Factory  }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment
        navController = navHostFragment.findNavController()
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_region_select,R.id.navigation_meal_planner,R.id.navigation_shopping_list
            )
        )
        setSupportActionBar(binding.toolbar)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
//        shoppingListViewModel.items.observe(this, Observer {
//            println(it)
//        })
//        seeRecipes(recipeViewModel.getRecipes())
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    fun seeRecipes(recipes: List<RecipeEnt>){
        val catmap = HashMap<String,Int>()
        val metricmap = HashMap<String,Int>()
        val namemap = HashMap<String,Int>()
        recipes.forEach {
            val ingredientList = it.recipeShopping.split(",")
            if (ingredientList.size % 4 != 0){
                println("Recipe id " + it.name)
            } else {
                for (i in 0..ingredientList.size - 1 step 4) {
                    val cat = ingredientList[i+2].trim().lowercase()
                    val metric = ingredientList[i+1].trim().lowercase()
                    val name = ingredientList[i+3].trim().lowercase()
                    if (catmap.containsKey(cat)){
                        catmap[cat]!!.plus(1)
                    } else{
                        catmap.put(cat,1)
                    }

                    if (namemap.containsKey(name)){
                        namemap[name]!!.plus(1)
                    } else{
                        namemap.put(name,1)
                    }

                    if (metricmap.containsKey(metric)){
                        metricmap[metric]!!.plus(1)
                    } else{
                        metricmap.put(metric,1)
                    }
                }
            }
        }
        //println(namemap.keys.sorted())
//        println(metricmap)
//        println(catmap)
    }
}