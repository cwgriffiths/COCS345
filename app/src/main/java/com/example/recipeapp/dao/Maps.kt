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
    val cont: Map<String, Int> = mapOf(
            "north America" to 1,
            "south America" to 2,
            "africa" to 3,
            "europe" to 4,
            "asia" to 5,
            "oceania" to 6,
            "antarctica" to 7
    )
)
