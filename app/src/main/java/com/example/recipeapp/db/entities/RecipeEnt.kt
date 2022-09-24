package com.example.recipeapp.db.entities

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Parcelable data class to store a recipe
 * Acts as a row in the recipe table in the database
 */
@Entity(tableName = "recipe_table")
data class RecipeEnt(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "title") val name: String,
    @ColumnInfo(name = "description") val description: String,
    // 1= north america, 2 = south america, 3 = africa , 4 = europe, 5= Asia, 6 = oceanania, 7 = antarictica
    @ColumnInfo(name = "region") val region: Int,
    @ColumnInfo(name = "ingredients") val ingredients: String,
    @ColumnInfo(name = "method") val method: String,
    @ColumnInfo(name = "servings") val servings: Int,
    @ColumnInfo(name = "country") val country: String,
    @ColumnInfo(name = "recipeShopping") val recipeShopping: String,
)
