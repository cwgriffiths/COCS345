package com.example.recipeapp.ui.recipe

import androidx.lifecycle.*
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.recipeapp.db.AppDB
import com.example.recipeapp.db.entities.RecipeEnt
import com.example.recipeapp.db.repos.RecipeRepo

/**
 * recipe view model to store all recipe data
 * @author Ariana,Conor,Cordell,Derek
 * @param repo the repo for the recipe data access
 * */
class RecipeViewModel(private val repo: RecipeRepo) : ViewModel() {
    private var recipes: List<RecipeEnt> = repo.getRecipes()
    private var curRecipe: RecipeEnt? = null
    var selectedRecipes = -1

    /**
     * Sets the current recipe property
     * @param recipe the recipe to set
     * */
    fun setCurRecipe(recipe: RecipeEnt) {
        this.curRecipe = recipe
    }

    /**
     * Inserts a recipe into the db
     * @param recipe the recipe to insert
     * */
    fun insertRecipe(recipe: RecipeEnt){
        repo.insertRecipe(recipe)
    }

    /**
     * Returns current recipe
     * @return the current recipe
     * */
    fun getCurRecipe(): RecipeEnt? {
        return curRecipe
    }

    /**
     * Gets a list of recipes
     * @return list of recipes
     * */
    fun getRecipes(): List<RecipeEnt> {
        setRecipes()
        return recipes
    }

    /**
     * Gets a recipe based off id
     * @param id of the recipe
     * @return recipe
     * */
    fun getRecipeById(id: Int): RecipeEnt {
        return repo.getRecipeById(id)
    }

    private fun setRecipes() {
        recipes = if (selectedRecipes == -1) {
            repo.getRecipes()
        } else {
            repo.getRecipeByCountry(selectedRecipes)
        }
    }

    companion object {

        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                // Get the Application object from extras
                val application = checkNotNull(extras[APPLICATION_KEY])
                // Create a SavedStateHandle for this ViewModel from extras
                val savedStateHandle = extras.createSavedStateHandle()
                val repo = RecipeRepo(AppDB.getInstance(application.applicationContext).recipeDAO())

                return RecipeViewModel(
                    (repo)
                ) as T
            }
        }
    }

}