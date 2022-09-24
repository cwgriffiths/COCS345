package com.example.recipeapp.entities

import org.junit.Assert.*

import org.junit.Test

/**
 * @author Conor Griffiths
 */
class ShoppingItemEntTest {

    private val shoppingItem = ShoppingItemEnt(1,"apple",2.0,"kg",false,"fruit")

    /**
     * Test if the shopping item is created correctly
     */
    @Test
    fun getId() {
        assertEquals(1,shoppingItem.id)
    }

    /**
     * Test if the getItem method returns the correct item
     */
    @Test
    fun getItem() {
        assertEquals("apple",shoppingItem.item)
    }

    /**
     * Test if the getAmount method returns the correct amount
     */
    @Test
    fun getAmount() {
        assertEquals(2.0,shoppingItem.amount, 0.0)
    }

    /**
     * Test if the getUnit method returns the correct unit
     */
    @Test
    fun getMetric() {
        assertEquals("kg",shoppingItem.metric)
    }

    /**
     * Test if the getChecked method returns the correct value
     */
    @Test
    fun getChecked() {
        assertEquals(false,shoppingItem.checked)
    }

    /**
     * Test is setChecked method sets the correct value
     */
    @Test
    fun setChecked() {
        shoppingItem.checked = true
        assertEquals(true,shoppingItem.checked)
    }

    /**
     * Tests the get category method
     */
    @Test
    fun getCat() {
        assertEquals("fruit",shoppingItem.cat)
    }

    /**
     * Tests copy method
     */
    @Test
    fun copy() {
        val copy = shoppingItem.copy()
        assertEquals(copy,shoppingItem)
    }

    /**
     * Tests the toString method
     */
    @Test
    fun testToString() {
        assertEquals("ShoppingItemEnt(id=1, item=apple, amount=2.0, metric=kg, checked=false, cat=fruit)",shoppingItem.toString())
    }

    /**
     * Tests the equals method
     */
    @Test
    fun testEquals() {
        val copy = shoppingItem.copy()
        assertEquals(copy,shoppingItem)
    }
}