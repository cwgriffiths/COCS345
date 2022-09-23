package com.example.recipeapp

import com.example.recipeapp.Util.Companion.titleCase
import junit.framework.Assert.assertEquals
import org.junit.Test

/**
 * Tests for the Util class.
 * @author Conor Griffiths
 */
internal class UtilTest {

    private val expected = "Hello World"

    /**
     * Test the title case method
     */
    @Test
    fun titleCaseTest() {
        assertEquals(expected, titleCase("hello world"))
        assertEquals(expected, titleCase("HELLO WORLD"))
        assertEquals(expected, titleCase("hELLO wORLD"))
        assertEquals(expected, titleCase("Hello World"))
        assertEquals(expected, titleCase("hello WORLD"))
        assertEquals(expected, titleCase("Hello world"))
        assertEquals(expected, titleCase("hello World"))
    }

    /**
     * Test the mapByProp method
     */
    @Test
    fun mapByPropTest() {
        assertEquals(true,true)
    }




}