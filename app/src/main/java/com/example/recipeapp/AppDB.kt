package com.example.recipeapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.recipeapp.dao.RecipeEntDAO
import com.example.recipeapp.entities.RecipeEnt

@Database(entities = [RecipeEnt::class], version = 1)
abstract class AppDB : RoomDatabase() {
    abstract fun recipeDAO(): RecipeEntDAO
}