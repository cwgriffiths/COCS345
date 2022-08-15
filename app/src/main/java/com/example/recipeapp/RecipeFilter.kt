package com.example.recipeapp

import android.content.Context
import com.example.recipeapp.dao.Maps
import com.example.recipeapp.entities.RecipeEnt

class RecipeFilter() {
    companion object{
        private var db: AppDB? = null;
        private val m = Maps()
        fun setup(view: Context){
            db = AppDB.getInstance(view)
        }
        fun getRecipesWithIngredients(inged : List<Int>){
            val recipes = db?.recipeDAO()?.getRecipes()
//            println(m.staples.keys)
//            println(m.staples.values)
//            println(m.staples.get("Milk"))
//            println(m.staples.getValue("Milk"))
            if (recipes != null) {
                for (r in recipes){
                    this.getRecipeStaples(r)
                }
            }
        }
        private fun getRecipeStaples(recipe : RecipeEnt){
            var a = recipe.ingredients.split("\\ ").toMutableList()
            val reg = Regex("\\[[^\\[\\]]+]")

            var staples = ArrayList<String>()
            println(a)
            println("aaaa")
            for(i in a){
                val ab= reg.findAll(i)
                val ac = ab.toMutableList()
                for(z in ac){
                    println(z.value)
                }

//                a[i] = (a[i].substring(a[i].indexOf("{")+1,a[i].indexOf("}"))).lowercase()
            }
//            for (i in a){
//                println(i)
//            }

        }
    }
}