package com.example.recipeapp.ui.recipe

import androidx.lifecycle.*
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.recipeapp.db.AppDB
import com.example.recipeapp.db.entities.RecipeEnt
import com.example.recipeapp.db.repos.RecipeRepo


class RecipeViewModel(private val repo: RecipeRepo) : ViewModel() {
    private var recipes: List<RecipeEnt> = repo.getRecipes()
    private var curRecipe: RecipeEnt? = null
    var selectedRecipes = -1

    fun setCurRecipe(recipe: RecipeEnt) {
        this.curRecipe = recipe
    }

    fun getCurRecipe(): RecipeEnt? {
        return curRecipe
    }

    fun getRecipes(): List<RecipeEnt> {
        setRecipes()
        return recipes
    }

    fun getRecipeById(id: Int): RecipeEnt {
        return repo.getRecipeById(id);
    }

    private fun setRecipes() {
        if (selectedRecipes == -1) {
            recipes = repo.getRecipes()
        } else {
            recipes = repo.getRecipeByCountry(selectedRecipes)
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
                    (repo as RecipeRepo)
                ) as T
            }
        }
    }

}