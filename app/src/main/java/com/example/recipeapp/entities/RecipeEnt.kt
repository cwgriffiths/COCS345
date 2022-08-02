package com.example.recipeapp.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipe_table")
data class RecipeEnt(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "title") val name: String,
    //Regions 1-7 represent the 7 continents
    @ColumnInfo(name = "region") val region: Int,
    @ColumnInfo(name = "ingredients") val ingredients: ArrayList<String>,
    @ColumnInfo(name = "method") val method: ArrayList<String>,
    @ColumnInfo(name = "extra_info") val extra: String,
    @ColumnInfo(name = "servings") val servings: Int
)