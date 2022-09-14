package com.example.recipeapp.dao

import org.junit.Assert.*

import org.junit.Test

class EmojisTest {

    @Test
    fun getEmoji() {
        val emoji = Emojis.Companion
        assertEquals(emoji.getEmoji("america"), "🇺🇸")
    }

    @Test
    fun getDefaultEmoji(){
        val emoji = Emojis.Companion
        assertEquals(emoji.getEmoji("not a country"), "🌎")
    }
}