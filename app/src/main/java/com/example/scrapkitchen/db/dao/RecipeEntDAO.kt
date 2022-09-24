package com.example.scrapkitchen.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.scrapkitchen.db.entities.RecipeEnt


@Dao
interface RecipeEntDAO {
    @Query("SELECT * FROM recipe_table WHERE region = (:region)")
    fun getRecipeByCountry(region: Int) : List<RecipeEnt>

    @Query("SELECT * FROM recipe_table ORDER BY id ASC")
    fun getRecipes() : List<RecipeEnt>

    @Query("SELECT * FROM recipe_table WHERE id = (:id)")
    fun getRecipeById(id: Int) : RecipeEnt

    @Insert
    fun insertRecipe(recipe: RecipeEnt)
}