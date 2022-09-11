package com.example.recipeapp.dao

data class Maps(
    val staples: Map<String, Int> = mapOf(
        "milk" to 1,
        "eggs" to 2,
        "flour" to 3,
        "rice" to 4,
        "potatoes" to 5,
        "butter" to 6,
        "pasta" to 7,
        "onions" to 8,
        "garlic" to 9,
        "kumara" to 10,
        "corn" to 11,
        "chicken" to 12,
        "bacon" to 13
    ),
    val NORTH_AMERICA: Int = 1,
    val SOUTH_AMERICA: Int = 2,
    val AFRICA: Int = 3,
    val EUROPE: Int = 4,
    val ASIA: Int = 5,
    val OCEANIA: Int = 6,


)
