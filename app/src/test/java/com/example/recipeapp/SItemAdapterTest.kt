package com.example.recipeapp

import org.junit.Test
import com.example.recipeapp.SItemAdapter.Companion.generateText
import junit.framework.Assert.assertEquals

class SItemAdapterTest{

    @Test
    fun testCompanion(){
        assertEquals("1kg", generateText("kg", 1))
        assertEquals("1g", generateText("g", 1))
        assertEquals("1 Whole", generateText("Whole", 1))
    }

}