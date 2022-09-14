package com.example.recipeapp.entities

import org.junit.Assert.*
import org.junit.Test

class MealPlannerEntTest {

    private val mealPlanner = MealPlannerEnt(1,2,3)

    @Test
    fun getId() {
        assertEquals(1, mealPlanner.id)
    }

    @Test
    fun getLunch_recipe() {
        assertEquals(2, mealPlanner.lunch_recipe)
    }

    @Test
    fun getDinner_recipe() {
        assertEquals(3, mealPlanner.dinner_recipe)
    }

    @Test
    fun copy() {
        val copy = mealPlanner.copy()
        assertEquals(copy, mealPlanner)
    }

    @Test
    fun testToString() {
        assertEquals("MealPlannerEnt(id=1, lunch_recipe=2, dinner_recipe=3)", mealPlanner.toString())
    }

    @Test
    fun testHashCode() {
        val copy = mealPlanner.copy()
        assertEquals(copy.hashCode(), mealPlanner.hashCode())
    }

    @Test
    fun testEquals() {
        val copy = mealPlanner.copy()
        assertEquals(copy, mealPlanner)
    }
}