package com.example.recipeapp.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.recipeapp.db.entities.RecipeEnt

/**
 * Defines methods for using the RecipeEnt class with Room.
 */
@Dao
interface RecipeEntDAO {

    /**
     * Get recipe by Contient ID
     */
    @Query("SELECT * FROM recipe_table WHERE region = (:region)")
    fun getRecipeByCountry(region: Int) : List<RecipeEnt>

    /**
     * Get all recipes
     */
    @Query("SELECT * FROM recipe_table ORDER BY id ASC")
    fun getRecipes() : List<RecipeEnt>

    /**
     * Get specific recipe by ID
     */
    @Query("SELECT * FROM recipe_table WHERE id = (:id)")
    fun getRecipeById(id: Int) : RecipeEnt

    /**
     * Insert recipe
     */
    @Insert
    fun insertRecipe(recipe: RecipeEnt)
}