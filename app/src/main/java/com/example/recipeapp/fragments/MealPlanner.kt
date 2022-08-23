package com.example.recipeapp.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.recipeapp.AppDB
import com.example.recipeapp.ListAdapter
import com.example.recipeapp.R
import com.example.recipeapp.activities.RecipeDetailActivity
import com.example.recipeapp.databinding.FragmentMealPlannerBinding
import com.example.recipeapp.databinding.FragmentRegionSelectBinding
import com.example.recipeapp.entities.RecipeEnt
import com.example.recipeapp.entities.MealPlannerEnt

class MealPlanner:Fragment(R.layout.fragment_meal_planner), View.OnClickListener {

    private lateinit var binding: FragmentMealPlannerBinding
    private lateinit var recipe: RecipeEnt
    private lateinit var mealList: List<MealPlannerEnt>


    // Have a reference to the veiw binding - all button=s nned id
    // Access each id one by one,
    // get ID from meal planner use that id to get from the recipe db

    private lateinit var view2 : View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_meal_planner, container, false)
        view2 = view



        binding = FragmentMealPlannerBinding.inflate(layoutInflater)



        binding.lunchMon.setOnClickListener(this)
        binding.dinnerMon.setOnClickListener(this)
        binding.lunchTue.setOnClickListener(this)
        binding.dinnerTue.setOnClickListener(this)
        binding.lunchWed.setOnClickListener(this)
        binding.dinnerWed.setOnClickListener(this)
        binding.lunchThu.setOnClickListener(this)
        binding.dinnerThu.setOnClickListener(this)
        binding.lunchSat.setOnClickListener(this)
        binding.dinnerSat.setOnClickListener(this)
        binding.lunchSun.setOnClickListener(this)
        binding.dinnerSun.setOnClickListener(this)




        return binding.root
    }

    override fun onClick(p0: View) {
        var typeMeal = 0
        val mealId = when(p0?.id){
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

        mealList = AppDB.getInstance(view2.context).mealPlannerDAO().getMealPlanner()

        var meal = mealList[mealId]


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