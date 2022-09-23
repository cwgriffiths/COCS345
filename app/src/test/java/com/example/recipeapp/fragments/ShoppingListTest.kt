package com.example.recipeapp.fragments

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import org.junit.Assert.*

import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito

class ShoppingListTest {

    /**
     * Test the onCreateOptionsMenu method
     */
    @Test
    fun onCreateOptionsMenu() {
        val shoppingList = ShoppingList()
        shoppingList.onCreateOptionsMenu(Mockito.mock(Menu::class.java), Mockito.mock(MenuInflater::class.java))
        assertNotNull(shoppingList)
    }

    /**
     * Test the on option selected method
     */
    @Test
    fun onOptionsItemSelected() {
        val shoppingList = ShoppingList()
        val result = shoppingList.onOptionsItemSelected(Mockito.mock(android.view.MenuItem::class.java))
        assertFalse(result)
    }

    /**
     * Test the view is created correctly
     */
    @Test
    fun onViewCreated() {

    }

    /**
     * Test item checked event
     */
    @Test
    fun onItemCheck() {

    }

    /**
     * Tests item swipe event
     */
    @Test
    fun onItemSwipe() {
    }

    /**
     * Test pause
     */
    @Test
    fun onPause() {
    }

    /**
     * Test resume
     */
    @Test
    fun onResume() {
    }

    /**
     * Test toString
     */
    @Test
    fun testToString() {
        val shoppingList = ShoppingList()
        val result = shoppingList.toString()
        assertEquals("Shopping List", result)
    }
}