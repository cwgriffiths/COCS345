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

class MealPlanner:Fragment(R.layout.fragment_meal_planner), View.OnClickListener {

    private lateinit var binding: FragmentMealPlannerBinding
    private lateinit var recipe: RecipeEnt
    private lateinit var mealList: List<MealPlannerEnt>

    private lateinit var view2 : View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_meal_planner, container, false)
        view2 = view


        mealList = AppDB.getInstance(view.context).mealPlannerDAO().getMealPlanner()

        binding = FragmentMealPlannerBinding.inflate(layoutInflater)

        var id = 0

        binding.lunchMon.setOnClickListener(this)
        id = mealList[0].lunch_recipe
        recipe = AppDB.getInstance(view2.context).recipeDAO().getRecipeById(id)
        binding.lunchMon.text = recipe.name

        binding.dinnerMon.setOnClickListener(this)
        id = mealList[0].dinner_recipe
        recipe = AppDB.getInstance(view2.context).recipeDAO().getRecipeById(id)
        binding.dinnerMon.text = recipe.name


        binding.lunchTue.setOnClickListener(this)
        id = mealList[1].lunch_recipe
        recipe = AppDB.getInstance(view2.context).recipeDAO().getRecipeById(id)
        binding.lunchTue.text = recipe.name

        binding.dinnerTue.setOnClickListener(this)
        id = mealList[1].dinner_recipe
        recipe = AppDB.getInstance(view2.context).recipeDAO().getRecipeById(id)
        binding.dinnerTue.text = recipe.name

        binding.lunchWed.setOnClickListener(this)
        id = mealList[2].lunch_recipe
        recipe = AppDB.getInstance(view2.context).recipeDAO().getRecipeById(id)
        binding.lunchWed.text = recipe.name

        binding.dinnerWed.setOnClickListener(this)
        id = mealList[2].dinner_recipe
        recipe = AppDB.getInstance(view2.context).recipeDAO().getRecipeById(id)
        binding.dinnerWed.text = recipe.name

        binding.lunchThu.setOnClickListener(this)
        id = mealList[3].lunch_recipe
        recipe = AppDB.getInstance(view2.context).recipeDAO().getRecipeById(id)
        binding.lunchThu.text = recipe.name

        binding.dinnerThu.setOnClickListener(this)
        id = mealList[3].dinner_recipe
        recipe = AppDB.getInstance(view2.context).recipeDAO().getRecipeById(id)
        binding.dinnerThu.text = recipe.name

        binding.lunchFri.setOnClickListener(this)
        id = mealList[4].lunch_recipe
        recipe = AppDB.getInstance(view2.context).recipeDAO().getRecipeById(id)
        binding.lunchFri.text = recipe.name


        binding.dinnerFri.setOnClickListener(this)
        id = mealList[4].dinner_recipe
        recipe = AppDB.getInstance(view2.context).recipeDAO().getRecipeById(id)
        binding.dinnerFri.text = recipe.name

        binding.lunchSat.setOnClickListener(this)
        id = mealList[5].lunch_recipe
        recipe = AppDB.getInstance(view2.context).recipeDAO().getRecipeById(id)
        binding.lunchSat.text = recipe.name

        binding.dinnerSat.setOnClickListener(this)
        id = mealList[5].dinner_recipe
        recipe = AppDB.getInstance(view2.context).recipeDAO().getRecipeById(id)
        binding.dinnerSat.text = recipe.name

        binding.lunchSun.setOnClickListener(this)
        id = mealList[6].lunch_recipe
        recipe = AppDB.getInstance(view2.context).recipeDAO().getRecipeById(id)
        binding.lunchSun.text = recipe.name

        binding.dinnerSun.setOnClickListener(this)
        id = mealList[6].dinner_recipe
        recipe = AppDB.getInstance(view2.context).recipeDAO().getRecipeById(id)
        binding.dinnerSun.text = recipe.name





        return binding.root
    }

    override fun onClick(p0: View) {
        var typeMeal = 0
        val mealId = when(p0.id){
            R.id.lunchMon -> {
                typeMeal = 0
                0
            }
            R.id.dinnerMon -> {
                typeMeal = 1
                0
            }
            R.id.lunchTue -> {
                typeMeal = 0
                1
            }
            R.id.dinnerTue -> {
                typeMeal = 1
                1
            }
            R.id.lunchWed -> {
                typeMeal = 0
                2
            }
            R.id.dinnerWed -> {
                typeMeal = 1
                2
            }
            R.id.lunchThu -> {
                typeMeal = 0
                3
            }
            R.id.dinnerThu -> {
                typeMeal = 1
                3
            }
            R.id.lunchFri -> {
                typeMeal = 0
                4
            }
            R.id.dinnerFri -> {
                typeMeal = 1
                4
            }
            R.id.lunchSat -> {
                typeMeal = 0
                5
            }
            R.id.dinnerSat -> {
                typeMeal = 1
                5
            }
            R.id.lunchSun -> {
                typeMeal = 0
                6
            }
            R.id.dinnerSun -> {
                typeMeal = 1
                6
            }
            else -> {
                -1
            }
        }

        // AppDB.getInstance(view2.context).mealPlannerDAO().addItem()

        //mealList = AppDB.getInstance(view2.context).mealPlannerDAO().getMealPlanner()

        //print(mealList)

        val meal = mealList[mealId]


        val id = if (typeMeal == 0){
            meal.lunch_recipe
        } else {
            meal.dinner_recipe
        }

        recipe = AppDB.getInstance(view2.context).recipeDAO().getRecipeById(id)
        val intent = Intent (context, RecipeDetailActivity()::class.java)
        intent.putExtra("recipe", recipe)
        startActivity(intent)
    }

    /**
     * Returns this instance as a string
     * Used to set the title of the view
     */
    override fun toString(): String {
        return "Meal Planner"
    }

}