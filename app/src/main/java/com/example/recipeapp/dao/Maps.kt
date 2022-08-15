package com.example.recipeapp.dao

data class Maps(
    val staples: Map<String, Int> = mapOf(
        "Milk" to 1,
        "Eggs" to 2,
        "Flour" to 3,
        "Rice" to 4,
        "Potatoes" to 5,
        "Butter" to 6,
        "Pasta" to 7,
        "Onions" to 8,
        "Garlic" to 9,
        "Kumara" to 10,
        "Corn" to 11,
        "Chicken" to 12,
        "Bacon" to 13
    ),
    val NORTH_AMERICA: Int = 1,
    val SOUTH_AMERICA: Int = 2,
    val AFRICA: Int = 3,
    val EUROPE: Int = 4,
    val ASIA: Int = 5,
    val OCEANIA: Int = 6,
)
