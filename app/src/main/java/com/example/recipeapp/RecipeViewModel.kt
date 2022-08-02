package com.example.recipeapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipeapp.entities.RecipeEnt
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RecipeViewModel(application: Application): AndroidViewModel(application) {
    private val readAllData: List<RecipeEnt>
    private val repository: RecipeRepository

    init {
        val recipeDao = AppDB.getInstance(application).recipeDAO()
        repository = RecipeRepository(recipeDao)
        readAllData = repository.getAllRecipes
    }

    fun addRecipe(recipe: Recipe) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertRecipe(recipe)
        }
    }
}