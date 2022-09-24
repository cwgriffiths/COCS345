package com.example.recipeapp

import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import com.example.recipeapp.db.entities.ShoppingItemEnt
import com.example.recipeapp.ui.shoppingList.ShoppingListItemAdapter
import com.example.recipeapp.ui.shoppingList.ShoppingListFragment
import com.example.recipeapp.ui.shoppingList.ShoppingListViewModel
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

/**
 * Tests for Shopping Item Adapter
 * @author Connor Griffiths
 */
@RunWith(MockitoJUnitRunner::class)
class SItemAdapterTest {

    private val sItem = ShoppingItemEnt(1, "item", 1.0, "unit", true, "food")

    @Mock
    lateinit var mockText: TextView

    @Mock
    lateinit var mockCheckBox: CheckBox

    @Mock
    lateinit var view: View

    @Before
    /**fun setUp() {
        `when`(view.findViewById<TextView>(R.id.s_got)).thenReturn(mockCheckBox)
        `when`(view.findViewById<TextView>(R.id.slist_name)).thenReturn(mockText)
        `when`(view.findViewById<TextView>(R.id.slist_amount_metric)).thenReturn(mockText)
    }*/


    /**
     * Teest getItemCount is accurate
     */
    @Test
    fun getItemCount() {
        val tObject = ShoppingListItemAdapter(mutableListOf(sItem), Mockito.mock(ShoppingListViewModel::class.java))
        assertEquals(1, tObject.itemCount)
    }

    /**
     * Test delete item

    @Test
    fun deleteItem() {
        val tObject = ShoppingListItemAdapter(listOf(sItem), Mockito.mock(ShoppingListViewModel::class.java))
        tObject.deleteItem(0)
        assertEquals(0, tObject.itemCount)
    }
    */
}