package com.example.recipeapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.recipeapp.dao.RecipeEntDAO
import com.example.recipeapp.dao.ShoppingItemEntDAO
import com.example.recipeapp.entities.RecipeEnt
import com.example.recipeapp.entities.ShoppingItemEnt

@Database(entities = [RecipeEnt::class,ShoppingItemEnt::class], version = 1, exportSchema = true)

abstract class AppDB : RoomDatabase() {
    abstract fun recipeDAO(): RecipeEntDAO
    abstract fun shoppingItemDAO(): ShoppingItemEntDAO


    /**
     * The only instance of the database. Implementing Singleton pattern.
     * Checks if the database is null, if the database is null creates new
     * database from assets folder.
     */
    companion object {
        @Volatile
        private var INSTANCE: AppDB? = null

        /**
         * Returns the only instance of the database.
         * @param context The context of the application.
         * @return The only instance of the database.
         */
        fun getInstance(context: Context): AppDB {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDB::class.java,
                        "recipe_database"
                    ).createFromAsset("database/recipe_table.db").allowMainThreadQueries().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

}