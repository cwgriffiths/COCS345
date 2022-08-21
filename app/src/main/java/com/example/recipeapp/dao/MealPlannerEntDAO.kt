/*
* Author: Ariana
*
* */

package com.example.recipeapp.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.recipeapp.entities.MealPlannerEnt

@Dao
interface MealPlannerEntDAO {
    @Query("SELECT * FROM meal_planner_table")
    fun getMealPlanner() : List<MealPlannerEnt>

    @Query("SELECT lunch_recipe FROM meal_planner_table WHERE id = 0")
    fun getMondayLunch() : MealPlannerEnt
}


