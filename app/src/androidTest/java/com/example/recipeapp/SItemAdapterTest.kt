package com.example.recipeapp

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.test.InstrumentationRegistry.getContext
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import com.example.recipeapp.entities.ShoppingItemEnt
import com.example.recipeapp.fragments.ShoppingList
import org.junit.Assert
import org.junit.Test

class SItemAdapterTest {

    private val sItem = ShoppingItemEnt(1, "item", 1, "unit", true, "food")
/**
    @Test
    fun onCreateViewHolder() {
        val adapter = SItemAdapter(listOf(sItem), ShoppingList())
        val view = View(getApplicationContext())
        val viewHolder = adapter.onCreateViewHolder(view as ViewGroup, 0)
        Assert.assertNotNull(viewHolder)
    }

    @Test
    fun onBindViewHolder() {
        val adapter = SItemAdapter(listOf(sItem), ShoppingList())
        val parent = View(getApplicationContext())
        val viewHolder = adapter.MyViewHolder(parent, ShoppingList())
        adapter.onBindViewHolder(viewHolder, 0)
        Assert.assertEquals(viewHolder.name.text, "item")

    }
    */
}