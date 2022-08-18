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

class MealPlanner:Fragment(R.layout.fragment_meal_planner), ListAdapter.OnItemClickListener {

    private lateinit var binding: FragmentMealPlannerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_meal_planner, container, false)


        binding = FragmentMealPlannerBinding.inflate(layoutInflater)

        binding.lunchMon.setOnClickListener {
            val recipe = AppDB.getInstance(view.context).recipeDAO().getRecipeById(151)
            val intent = Intent(context, RecipeDetailActivity()::class.java)
            intent.putExtra("recipe", recipe)
            startActivity(intent)
        }
//        binding.dinnerMon.setOnClickListener(this)
//        binding.lunchTue.setOnClickListener(this)
//        binding.dinnerTue.setOnClickListener(this)
//        binding.lunchWed.setOnClickListener(this)
//        binding.dinnerWed.setOnClickListener(this)
//        binding.lunchThu.setOnClickListener(this)
//        binding.dinnerThu.setOnClickListener(this)
//        binding.lunchSat.setOnClickListener(this)
//        binding.dinnerSat.setOnClickListener(this)
//        binding.lunchSun.setOnClickListener(this)
//        binding.dinnerSun.setOnClickListener(this)




        return binding.root
    }

    override fun onItemClick(recipe: RecipeEnt) {

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