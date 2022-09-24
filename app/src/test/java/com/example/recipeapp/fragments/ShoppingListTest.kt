package com.example.recipeapp.fragments

import android.view.Menu
import android.view.MenuInflater
import com.example.recipeapp.ui.shoppingList.ShoppingListFragment
import org.junit.Assert.*

import org.junit.Test
import org.mockito.Mockito

/**
 * Tests for the shopping list fragment
 * @author Conor Griffiths
 */
class ShoppingListTest {

    /**
     * Test the onCreateOptionsMenu method
     */
    @Test
    fun onCreateOptionsMenu() {
        val shoppingList = ShoppingListFragment()
        shoppingList.onCreateOptionsMenu(Mockito.mock(Menu::class.java), Mockito.mock(MenuInflater::class.java))
        assertNotNull(shoppingList)
    }

    /**
     * Test the on option selected method
     */
    @Test
    fun onOptionsItemSelected() {
        val shoppingList = ShoppingListFragment()
        val result = shoppingList.onOptionsItemSelected(Mockito.mock(android.view.MenuItem::class.java))
        assertFalse(result)
    }

    /**
     * Test toString
     */
    @Test
    fun testToString() {
        val shoppingList = ShoppingListFragment()
        val result = shoppingList.toString()
        assertEquals("Shopping List", result)
    }
}