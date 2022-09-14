package com.example.recipeapp.fragments

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import org.junit.Assert.*

import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito

class ShoppingListTest {

    @Test
    fun onCreateOptionsMenu() {
        val shoppingList = ShoppingList()
        shoppingList.onCreateOptionsMenu(Mockito.mock(Menu::class.java), Mockito.mock(MenuInflater::class.java))
        assertNotNull(shoppingList)
    }

    @Test
    fun onOptionsItemSelected() {
        val shoppingList = ShoppingList()
        val result = shoppingList.onOptionsItemSelected(Mockito.mock(android.view.MenuItem::class.java))
        assertFalse(result)
    }

    @Test
    fun onViewCreated() {

    }

    @Test
    fun onItemCheck() {

    }

    @Test
    fun onItemSwipe() {
    }

    @Test
    fun onPause() {
    }

    @Test
    fun onResume() {
    }

    @Test
    fun testToString() {
        val shoppingList = ShoppingList()
        val result = shoppingList.toString()
        assertEquals("Shopping List", result)
    }
}