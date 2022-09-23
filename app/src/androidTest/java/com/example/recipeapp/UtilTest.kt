package com.example.recipeapp

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author Conor Griffiths
 */
@RunWith(AndroidJUnit4::class)
class UtilTest {

    /**
     * Test that the [Util.stringToFormattedList] function returns a list of recipes.
     */
    @Test
    fun stringToFormattedListTest() {
        assertEquals("hello, world\n\n", Util.stringToFormattedList("hello, world").toString())
        assertEquals("hello\n\nworld\n\n", Util.stringToFormattedList("hello \\ world\n").toString())
        assertEquals("hello, world\n\n", Util.stringToFormattedList("[hello], [world]").toString())

    }

}