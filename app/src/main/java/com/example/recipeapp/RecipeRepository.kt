package com.example.recipeapp

import com.example.recipeapp.dao.RecipeEntDAO
import com.example.recipeapp.entities.RecipeEnt

class RecipeRepository(private val recipeEntDAO: RecipeEntDAO) {
    val getAllRecipes: List<RecipeEnt> = recipeEntDAO.getRecipes()

    suspend fun insertRecipe(recipe: RecipeEnt) {
        recipeEntDAO.insertRecipe(recipe)
    }
}