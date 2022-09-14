package com.example.recipeapp

import android.graphics.Color
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.BulletSpan
import androidx.core.text.toSpannable
import com.example.recipeapp.entities.ShoppingItemEnt

class Util {
    companion object {
        fun mapByProp(items : List<ShoppingItemEnt>) : Map<String, MutableList<ShoppingItemEnt>> {
            var map = HashMap<String,MutableList<ShoppingItemEnt>>()
            items.forEach{
                if (map.containsKey(it.cat.lowercase())){
                    map[it.cat.lowercase()]?.add(it)
                } else{
                    map[it.cat.lowercase()] = mutableListOf(it)
                }
            }
            return map.toMap()
        }

        fun titleCase(str : String): String{
            var strList = str.split(" ")
            var bob = StringBuilder()
            strList.forEach { it ->
                bob.append( it.lowercase().replaceFirstChar { it.titlecase() })
                bob.append(" ")
            }
            return bob.toString().trim()
        }

        /**
         * Take a comma separated string and return a string formatted with bullet points and new lines
         */
        fun stringToFormattedList(s: String): Spannable {
            val builder = SpannableStringBuilder()
            val newS = s.replace("[","").replace("]","")

            val ingredients = newS.split("\\").toMutableList()
            val newIngredients = ArrayList<String>()

            for (i in 0..ingredients.lastIndex) {
                if(i!=ingredients.lastIndex && ingredients[i].contains("Step")) {
                    newIngredients.add("${ingredients[i]}\n${ingredients[i+1].trim()}")
                    ingredients[i+1] = ""
                }else if(ingredients[i].isNotEmpty()) {
                    newIngredients.add(ingredients[i])
                }
            }
            for (ingredient in newIngredients){
                    builder.append(
                        "${ingredient.trim()}\n\n",
                        BulletSpan(20, Color.DKGRAY, 6),
                        SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE
                    )
            }
            return builder.toSpannable()
        }
    }
}