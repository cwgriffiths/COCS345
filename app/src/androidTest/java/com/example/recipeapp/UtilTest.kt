package com.example.recipeapp

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UtilTest {

    @Test
    fun stringToFormattedListTest() {
        assertEquals("hello, world\n\n", Util.stringToFormattedList("hello, world").toString())
        assertEquals("hello\n\nworld\n\n", Util.stringToFormattedList("hello \\ world\n").toString())
        assertEquals("hello, world\n\n", Util.stringToFormattedList("[hello], [world]").toString())

    }

}