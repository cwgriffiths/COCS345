package com.example.recipeapp.ui.recipe

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import com.example.recipeapp.R
import com.example.recipeapp.Util.Companion.stringToFormattedList
import com.example.recipeapp.consts.Emojis
import com.example.recipeapp.databinding.FragmentRecipeBinding
import com.example.recipeapp.db.entities.RecipeEnt
import com.example.recipeapp.ui.mealPlanner.MealPlannerSelectDialog
import com.example.recipeapp.ui.shoppingList.ShoppingListViewModel


class RecipeFragment : Fragment() {

    private lateinit var binding: FragmentRecipeBinding
    private val emojis = Emojis.Companion

    private val shoppingListViewModel: ShoppingListViewModel by activityViewModels { ShoppingListViewModel.Factory}
    private val recipeViewModel: RecipeViewModel by activityViewModels { RecipeViewModel.Factory}
    private lateinit var recipe: RecipeEnt

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        recipe = recipeViewModel.getCurRecipe()!!
        val fragmentBinding = FragmentRecipeBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        binding.flag.text = emojis.getEmoji(recipe.country)
        binding.titleTxt.text = recipe.name.replace("(","\n(")
        binding.descriptionTxt.text = recipe.description
        binding.ingredientsTxt.text = stringToFormattedList(recipe.ingredients)
        binding.methodTxt.text = stringToFormattedList(recipe.method)
        binding.servesTxt.text = "Serves ${recipe.servings}"
        return fragmentBinding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.recipe_menu,menu)
        true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.addToList ->{
                findNavController().navigate(R.id.action_recipeFragment_to_addListFromRecipeFragment)
            }
            R.id.addToMealPlanner -> {
                MealPlannerSelectDialog().show(
                    childFragmentManager, MealPlannerSelectDialog.TAG)
            }
        }
        return if (item.itemId == R.id.addToList){
            findNavController().navigate(R.id.action_recipeFragment_to_addListFromRecipeFragment)
            true
        } else{
            item.onNavDestinationSelected(findNavController()) || super.onOptionsItemSelected(item)
        }
    }

    override fun toString(): String {
        return recipe.name
    }


}