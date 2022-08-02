package com.example.recipeapp.entities

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RecipeEnt(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "country") val country: String,
    @ColumnInfo(name = "ingredients") val ingredients: String,
    @ColumnInfo(name = "method") val method: String,
    @ColumnInfo(name = "extra_info") val extra: String,
    @ColumnInfo(name = "servings") val servings: String
)