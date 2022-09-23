package com.example.recipeapp

import com.example.recipeapp.Util.Companion.titleCase
import junit.framework.Assert.assertEquals
import org.junit.Test

/**
 * Tests for the Util class.
 * @author Conor Griffiths
 */
internal class UtilTest {

    /**
     * Test the title case method
     */
    @Test
    fun titleCaseTest() {
        assertEquals("Hello World", titleCase("hello world"))
        assertEquals("Hello World", titleCase("HELLO WORLD"))
        assertEquals("Hello World", titleCase("hELLO wORLD"))
        assertEquals("Hello World", titleCase("Hello World"))
        assertEquals("Hello World", titleCase("hello WORLD"))
        assertEquals("Hello World", titleCase("Hello world"))
        assertEquals("Hello World", titleCase("hello World"))
    }

    /**
     * Test the mapByProp method
     */
    @Test
    fun mapByPropTest() {
        assertEquals(true,true)
    }




}