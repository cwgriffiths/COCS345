package com.example.recipeapp.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * MealPlanner Entity data class
 *
 * @author Ariana A
 */
@Entity(tableName = "meal_planner_table")
data class MealPlannerEnt (
    @PrimaryKey(autoGenerate = false) val id: Int,
    @ColumnInfo(name = "lunch_recipe") val lunch_recipe: Int,
    @ColumnInfo(name = "dinner_recipe") val dinner_recipe: Int
)