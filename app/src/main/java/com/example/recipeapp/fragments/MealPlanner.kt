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

class MealPlanner:Fragment(R.layout.fragment_meal_planner), View.OnClickListener {

    private lateinit var binding: FragmentMealPlannerBinding
    private lateinit var recipe: RecipeEnt

    // Have a reference to the veiw binding - all button=s nned id
    // Access each id one by one,
    // get ID from meal planner use that id to get from the recipe db


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_meal_planner, container, false)

        recipe = AppDB.getInstance(view.context).recipeDAO().getRecipeById(151)


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

    override fun onClick(p0: View?) {
        // Currently random recipe
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

    /**
     * Sets the recipe to be displayed
     * Do not think this should be in here but just for now
     */
    fun setRecipe(recipe: RecipeEnt) {
        this.recipe = recipe
    }

}