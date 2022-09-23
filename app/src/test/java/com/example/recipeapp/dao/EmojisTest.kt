package com.example.recipeapp.dao

import org.junit.Assert.*

import org.junit.Test

class EmojisTest {

    /**
     * Test that getting an emoji works correctly
     */
    @Test
    fun getEmoji() {
        val emoji = Emojis.Companion
        assertEquals(emoji.getEmoji("america"), "🇺🇸")
    }

    /**
     * Test that getting an emoji that doesn't exist returns the world
     */
    @Test
    fun getDefaultEmoji(){
        val emoji = Emojis.Companion
        assertEquals(emoji.getEmoji("not a country"), "🌎")
    }
}