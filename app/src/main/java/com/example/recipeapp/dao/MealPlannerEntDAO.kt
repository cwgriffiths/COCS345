

package com.example.recipeapp.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.recipeapp.entities.MealPlannerEnt

/**
 * MealPlanner Entity DAO
 * @author Ariana
 */
@Dao
interface MealPlannerEntDAO {

    /**
     * Get all meal planner entries
     */
    @Query("SELECT * FROM meal_planner_table")
    fun getMealPlanner() : List<MealPlannerEnt>

    /**
     * Get the meal planner entry for a specific day
     */
    @Query("UPDATE meal_planner_table SET dinner_recipe = (:recipe_id) WHERE id = (:id)")
    fun addToMealPlanner(id : Int, recipe_id : Int)
}


