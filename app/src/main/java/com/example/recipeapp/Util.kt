package com.example.recipeapp

import com.example.recipeapp.entities.ShoppingItemEnt

class Util {
    companion object {
        fun mapByProp(items : List<ShoppingItemEnt>) : Map<String, MutableList<ShoppingItemEnt>> {
            var map = HashMap<String,MutableList<ShoppingItemEnt>>();
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
            return bob.toString()
        }
    }
}