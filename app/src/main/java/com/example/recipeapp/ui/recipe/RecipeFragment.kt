package com.example.recipeapp.ui.recipe

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.recipeapp.R
import com.example.recipeapp.Util.Companion.stringToFormattedList
import com.example.recipeapp.consts.Emojis
import com.example.recipeapp.databinding.FragmentRecipeBinding
import com.example.recipeapp.db.entities.RecipeEnt
import com.example.recipeapp.ui.mealPlanner.MealPlannerSelectDialog

/**
 * Recipe fragment for any recipe, sets up the binding
 * @author Ariana,Conor,Cordell,Derek
 * */
class RecipeFragment : Fragment() {

    private lateinit var binding: FragmentRecipeBinding
    private val emojis = Emojis.Companion


    private val recipeViewModel: RecipeViewModel by activityViewModels { RecipeViewModel.Factory }
    private lateinit var recipe: RecipeEnt

    /**
     * Sets the binding fields to the current recipe in the view model
     * */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        recipe = recipeViewModel.getCurRecipe()!!
        val fragmentBinding = FragmentRecipeBinding.inflate(inflater)
        binding = fragmentBinding
        binding.flag.text = emojis.getEmoji(recipe.country)
        binding.titleTxt.text = recipe.name.replace("(", "\n(")
        binding.descriptionTxt.text = recipe.description
        binding.ingredientsTxt.text = stringToFormattedList(recipe.ingredients)
        binding.methodTxt.text = stringToFormattedList(recipe.method)
        binding.servesTxt.text = "Serves ${recipe.servings}"
        return fragmentBinding.root
    }

    /**
     * Enables the toolbar menu
     * @param savedInstanceState bundle of state
     * */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    /**
     * Inflates the menu with the recipe_menu layout
     * @param menu the menu in the toolbar
     * @param inflater the inflater object
     * */
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.recipe_menu, menu)
    }

    /**
     * Creating click handler for each toolbar menu item
     * @param item the menu option that was selected
     * @return a boolean
     * */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.addToList -> {
                findNavController().navigate(R.id.action_recipeFragment_to_addListFromRecipeFragment)
                return true
            }
            R.id.addToMealPlanner -> {
                MealPlannerSelectDialog().show(
                    childFragmentManager, MealPlannerSelectDialog.TAG
                )
                return true
            }
        }
        return false
    }

}