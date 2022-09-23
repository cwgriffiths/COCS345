package com.example.recipeapp.entities

import org.junit.Assert.*
import org.junit.Test

class MealPlannerEntTest {

    private val mealPlanner = MealPlannerEnt(1,2,3)

    /**
     * Test to see if the meal planner id is created correctly
     */
    @Test
    fun getId() {
        assertEquals(1, mealPlanner.id)
    }

    /**
     * Test to see if get lunch method returns correct value
     */
    @Test
    fun getLunch_recipe() {
        assertEquals(2, mealPlanner.lunch_recipe)
    }

    /**
     * Test to see if get dinner method returns correct value
     */
    @Test
    fun getDinner_recipe() {
        assertEquals(3, mealPlanner.dinner_recipe)
    }

    /**
     * Test copy method
     */
    @Test
    fun copy() {
        val copy = mealPlanner.copy()
        assertEquals(copy, mealPlanner)
    }

    /**
     * Test to see if toString method returns correct value
     */
    @Test
    fun testToString() {
        assertEquals("MealPlannerEnt(id=1, lunch_recipe=2, dinner_recipe=3)", mealPlanner.toString())
    }

    /**
     * Test to see if hashCode method returns correct value
     */
    @Test
    fun testHashCode() {
        val copy = mealPlanner.copy()
        assertEquals(copy.hashCode(), mealPlanner.hashCode())
    }

    /**
     * Test to see if equals method returns correct value
     */
    @Test
    fun testEquals() {
        val copy = mealPlanner.copy()
        assertEquals(copy, mealPlanner)
    }
}