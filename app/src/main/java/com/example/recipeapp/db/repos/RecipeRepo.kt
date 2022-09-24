package com.example.recipeapp.db.repos

import androidx.annotation.WorkerThread
import com.example.recipeapp.db.dao.RecipeEntDAO
import com.example.recipeapp.db.entities.RecipeEnt

class RecipeRepo(private val dao: RecipeEntDAO) {
    private val recipes : List<RecipeEnt> = dao.getRecipes()

    fun getRecipes() : List<RecipeEnt>{
        return recipes
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    fun insertRecipe(recipe: RecipeEnt){
        dao.insertRecipe(recipe)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    fun getRecipeByCountry(region: Int) : List<RecipeEnt> {
        return dao.getRecipeByCountry(region)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    fun getRecipeById(id: Int) : RecipeEnt {
        return dao.getRecipeById(id)
    }


}