package com.example.recipeapp.entities

import org.junit.Assert.*

import org.junit.Test

class ShoppingItemEntTest {

    private val shoppingItem = ShoppingItemEnt(1,"apple",2,"kg",false,"fruit")

    @Test
    fun getId() {
        assertEquals(1,shoppingItem.id)
    }

    @Test
    fun getItem() {
        assertEquals("apple",shoppingItem.item)
    }

    @Test
    fun getAmount() {
        assertEquals(2,shoppingItem.amount)
    }

    @Test
    fun getMetric() {
        assertEquals("kg",shoppingItem.metric)
    }

    @Test
    fun getChecked() {
        assertEquals(false,shoppingItem.checked)
    }

    @Test
    fun setChecked() {
        shoppingItem.checked = true
        assertEquals(true,shoppingItem.checked)
    }

    @Test
    fun getCat() {
        assertEquals("fruit",shoppingItem.cat)
    }

    @Test
    fun copy() {
        val copy = shoppingItem.copy()
        assertEquals(copy,shoppingItem)
    }

    @Test
    fun testToString() {
        assertEquals("ShoppingItemEnt(id=1, item=apple, amount=2, metric=kg, checked=false, cat=fruit)",shoppingItem.toString())
    }

    @Test
    fun testHashCode() {
        val copy = shoppingItem.copy()
        assertEquals(copy.hashCode(),shoppingItem.hashCode())
    }

    @Test
    fun testEquals() {
        val copy = shoppingItem.copy()
        assertEquals(copy,shoppingItem)
    }
}