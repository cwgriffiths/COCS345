package com.example.recipeapp

import android.content.Context
import com.example.recipeapp.dao.Maps
import com.example.recipeapp.entities.RecipeEnt

class RecipeFilter {
    companion object{
        private var db: AppDB? = null
        private val m = Maps()
        fun setup(view: Context){
            db = AppDB.getInstance(view)
        }
        fun getRecipesWithIngredients(inged : List<Int>): Map<Int, List<Int>> {
            val recipes = db?.recipeDAO()?.getRecipes()
            var ids = mutableMapOf<Int,MutableList<Int>>()
            if (recipes != null) {
                for (r in recipes){
                    var count = 0
                    val staples = this.getRecipeStaples(r)
                    for (staple in staples){
                        if(inged.indexOf(m.staples[staple]) != -1){
                            count++
                        }
                    }
                    if (count >0) {
                        if (ids.containsKey(count)) {
                            ids[count]?.add(r.id)
                        } else {
                            ids.put(count, mutableListOf(r.id))
                        }
                    }
                }
            }
            return ids
        }
        private fun getRecipeStaples(recipe : RecipeEnt): List<String> {
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
            return staples.toList()
        }
    }
}