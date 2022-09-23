package com.example.recipeapp.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.recipeapp.AppDB
import com.example.recipeapp.R
import com.example.recipeapp.activities.RecipeDetailActivity
import com.example.recipeapp.databinding.FragmentMealPlannerBinding
import com.example.recipeapp.entities.RecipeEnt
import com.example.recipeapp.entities.MealPlannerEnt

/**
 * Meal Planner class
 * Git
 *
 * Add click listeners to fragment buttons to show Recipe
 * @author Ariana
 */
class MealPlanner:Fragment(R.layout.fragment_meal_planner), View.OnClickListener {

    private lateinit var binding: FragmentMealPlannerBinding
    private lateinit var recipe: RecipeEnt
    private lateinit var mealList: List<MealPlannerEnt>

    private lateinit var view2 : View

    /**
     * This method is called when the fragment is created.
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_meal_planner, container, false)
        view2 = view

        mealList = AppDB.getInstance(view.context).mealPlannerDAO().getMealPlanner()

        binding = FragmentMealPlannerBinding.inflate(layoutInflater)

        binding.dinnerMon.setOnClickListener(this)
        var id = mealList[0].dinner_recipe
        recipe = AppDB.getInstance(view.context).recipeDAO().getRecipeById(id)
        binding.dinnerMon.text = recipe.name

        binding.dinnerTue.setOnClickListener(this)
        id = mealList[1].dinner_recipe
        recipe = AppDB.getInstance(view.context).recipeDAO().getRecipeById(id)
        binding.dinnerTue.text = recipe.name

        binding.dinnerWed.setOnClickListener(this)
        id = mealList[2].dinner_recipe
        recipe = AppDB.getInstance(view.context).recipeDAO().getRecipeById(id)
        binding.dinnerWed.text = recipe.name

        binding.dinnerThu.setOnClickListener(this)
        id = mealList[3].dinner_recipe
        recipe = AppDB.getInstance(view.context).recipeDAO().getRecipeById(id)
        binding.dinnerThu.text = recipe.name


        binding.dinnerFri.setOnClickListener(this)
        id = mealList[4].dinner_recipe
        recipe = AppDB.getInstance(view.context).recipeDAO().getRecipeById(id)
        binding.dinnerFri.text = recipe.name

        binding.dinnerSat.setOnClickListener(this)
        id = mealList[5].dinner_recipe
        recipe = AppDB.getInstance(view.context).recipeDAO().getRecipeById(id)
        binding.dinnerSat.text = recipe.name

        binding.dinnerSun.setOnClickListener(this)
        id = mealList[6].dinner_recipe
        recipe = AppDB.getInstance(view.context).recipeDAO().getRecipeById(id)
        binding.dinnerSun.text = recipe.name

        return binding.root
    }

    /**
     * On button Click function
     * @param p0 the view
     */
    override fun onClick(p0: View) {
        val mealId = when(p0.id){
            R.id.dinnerMon -> {
                0
            }
            R.id.dinnerTue -> {
                1
            }
            R.id.dinnerWed -> {
                2
            }
            R.id.dinnerThu -> {
                3
            }
            R.id.dinnerFri -> {
                4
            }
            R.id.dinnerSat -> {
                5
            }
            R.id.dinnerSun -> {
                6
            }
            else -> {
                -1
            }
        }

        val meal = mealList[mealId]


        val id = meal.dinner_recipe


        recipe = AppDB.getInstance(view2.context).recipeDAO().getRecipeById(id)
        val intent = Intent (context, RecipeDetailActivity()::class.java)
        intent.putExtra("recipe", recipe)
        startActivity(intent)
    }

    /**
     * Returns this instance as a string
     * Used to set the title of the view
     * @return fragment name
     */
    override fun toString(): String {
        return "Meal Planner"
    }

}