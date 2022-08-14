package com.example.recipeapp

import android.content.Context

class RecipeFilter() {
    companion object{
        private var db: AppDB? = null;
        fun setup(view: Context){
            db = AppDB.getInstance(view)
        }
        fun test(){
            println(db?.recipeDAO()?.getRecipes())
        }

    }
}