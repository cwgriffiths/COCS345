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
            println(m.staples.keys)
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
            var ingredients = recipe.ingredients.split("\\ ").toMutableList()
            val reg = Regex("\\[[^\\[\\]]+]")
            var staples = ArrayList<String>()
            for(ing in ingredients){
                val matches = reg.findAll(ing)
                val listOfMatches = matches.toMutableList()
                for(match in listOfMatches){
                    if(m.staples.containsKey(match.value.lowercase().replace("[","").replace("]",""))){
                        staples.add(match.value.lowercase().replace("[","").replace("]",""))
                    }
                }
            }
            println(staples)
        }
    }
}