package com.example.recipeapp.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.recipeapp.entities.RecipeEnt

@Dao
interface RecipeEntDAO {
    @Query("SELECT * FROM RecipeEnt WHERE country = (:country)")
    fun getRecipeByCountry(country: String) : List<RecipeEnt>

    @Query("SELECT * FROM RecipeEnt")
    fun getRecipes() : List<RecipeEnt>

    @Insert
    fun insertRecipe(recipe: RecipeEnt)
}