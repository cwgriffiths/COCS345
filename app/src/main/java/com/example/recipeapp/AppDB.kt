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

    companion object {
        @Volatile
        private var INSTANCE: AppDB? = null

        fun getInstance(context: Context): AppDB {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDB::class.java,
                        "recipe_database"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

}