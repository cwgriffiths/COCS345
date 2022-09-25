package com.example.recipeapp.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.recipeapp.db.entities.MealPlannerEnt
import kotlinx.coroutines.flow.Flow


/**
 * MealPlanner Entity DAO
 * @author Ariana
 */
@Dao
interface MealPlannerEntDAO {
    @Query("SELECT * FROM meal_planner_table")
    fun getMealPlanner(): Flow<List<MealPlannerEnt>>

    @Query("UPDATE meal_planner_table SET dinner_recipe = (:recipeId) WHERE id = (:index)")
    fun updateMealPlanner(recipeId: Int, index: Int)

    @Insert
    fun setMealPlanner(mealPlanner: List<MealPlannerEnt>)
}


