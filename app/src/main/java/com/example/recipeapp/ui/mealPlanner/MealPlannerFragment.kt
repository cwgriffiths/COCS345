package com.example.recipeapp.ui.mealPlanner

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.recipeapp.R
import com.example.recipeapp.databinding.FragmentMealPlannerBinding
import com.example.recipeapp.ui.recipe.RecipeViewModel


class MealPlannerFragment : Fragment(), View.OnClickListener {

    private var binding: FragmentMealPlannerBinding? = null
    private var buttonList: MutableList<Button> = mutableListOf<Button>()

    private val mealPlannerViewModel: MealPlannerViewModel by activityViewModels { MealPlannerViewModel.Factory }
    private val recipeViewModel: RecipeViewModel by activityViewModels { RecipeViewModel.Factory }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentBinding = FragmentMealPlannerBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        buttonList.clear()
        buttonList.add(binding!!.dinnerMon)
        buttonList.add(binding!!.dinnerTue)
        buttonList.add(binding!!.dinnerWed)
        buttonList.add(binding!!.dinnerThu)
        buttonList.add(binding!!.dinnerFri)
        buttonList.add(binding!!.dinnerSat)
        buttonList.add(binding!!.dinnerSun)

        mealPlannerViewModel.items.observe(viewLifecycleOwner, Observer {
            mealPlannerViewModel.weekRecipes.clear()
            for (i in 0..buttonList.size - 1) {
                println(i)
                buttonList[i].setOnClickListener(this)
                var recipe = recipeViewModel.getRecipeById(it[i].dinner_recipe)
                mealPlannerViewModel.weekRecipes.add(recipe)
                buttonList[i].text = recipe.name
            }
        })


        return fragmentBinding.root
    }

    override fun onClick(view: View) {
        val recipe = mealPlannerViewModel.weekRecipes[buttonList.indexOf(view)]
        recipeViewModel.setCurRecipe(recipe)
        findNavController().navigate(R.id.action_mealPlannerFragment_to_recipeFragment)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}