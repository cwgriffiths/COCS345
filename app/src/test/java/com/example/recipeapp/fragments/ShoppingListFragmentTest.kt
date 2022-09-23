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
class ShoppingListFragmentTest {

    /**
     * Test the onCreateOptionsMenu method
     */
    @Test
    fun onCreateOptionsMenu() {
        val shoppingListFragment = ShoppingListFragment()
        shoppingListFragment.onCreateOptionsMenu(Mockito.mock(Menu::class.java), Mockito.mock(MenuInflater::class.java))
        assertNotNull(shoppingListFragment)
    }

    /**
     * Test the on option selected method
     */
    @Test
    fun onOptionsItemSelected() {
        val shoppingListFragment = ShoppingListFragment()
        val result = shoppingListFragment.onOptionsItemSelected(Mockito.mock(android.view.MenuItem::class.java))
        assertFalse(result)
    }

    /**
     * Test toString
     */
    @Test
    fun testToString() {
        val shoppingListFragment = ShoppingListFragment()
        val result = shoppingListFragment.toString()
        assertEquals("Shopping List", result)
    }
}