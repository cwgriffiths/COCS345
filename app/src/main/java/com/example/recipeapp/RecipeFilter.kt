package com.example.recipeapp

import android.content.Context
import com.example.recipeapp.dao.Maps

class RecipeFilter() {
    companion object{
        private var db: AppDB? = null;
        private val m = Maps()
        fun setup(view: Context){
            db = AppDB.getInstance(view)
        }
        fun getRecipesWithIngredients(inged : List<Int>){
            println(m.staples.keys)
            println(m.staples.values)
            println(m.staples.get("Milk"))
            println(m.staples.getValue("Milk"))
            println(m.staples.containsValue(1))
        }
    }
}