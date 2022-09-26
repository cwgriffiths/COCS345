package com.example.recipeapp.consts

import org.junit.Assert.*
import org.junit.Test

class EmojisTest{
    @Test
    fun getEmoji(){
        assertEquals(Emojis.getEmoji("south korea"),"\uD83C\uDDF0\uD83C\uDDF7")
        assertEquals(Emojis.getEmoji("Nowhereland"),"\uD83C\uDF0E")
    }
}