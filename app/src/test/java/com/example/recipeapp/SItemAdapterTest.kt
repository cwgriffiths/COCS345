package com.example.recipeapp

import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import com.example.recipeapp.entities.ShoppingItemEnt
import com.example.recipeapp.fragments.ShoppingList
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runner.manipulation.Ordering
import org.mockito.AdditionalAnswers.returnsFirstArg
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.doAnswer
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
        val tObject = SItemAdapter(mutableListOf(sItem), Mockito.mock(ShoppingList::class.java))
        assertEquals(1, tObject.itemCount)
    }

    /**
     * Test delete item
     */
    @Test
    fun deleteItem() {
        val tObject = SItemAdapter(listOf(sItem), Mockito.mock(ShoppingList::class.java))
        tObject.deleteItem(0)
        assertEquals(0, tObject.itemCount)
    }

    /**
     * Test the companion object
     */
    @Test
    fun testCompanion(){
        assertEquals("1.0kg", SItemAdapter.generateText("kg", 1.0))
        assertEquals("1.0g", SItemAdapter.generateText("g", 1.0))
        assertEquals("1.0 Whole", SItemAdapter.generateText("Whole", 1.0))
    }
}