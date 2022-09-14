package com.example.recipeapp.dao

import org.junit.Assert.*

import org.junit.Test

class MapsTest {

    private val maps = Maps()

    @Test
    fun getNORTH_AMERICA() {
        assertEquals(1, maps.NORTH_AMERICA)
    }

    @Test
    fun getSOUTH_AMERICA() {
        assertEquals(2, maps.SOUTH_AMERICA)
    }

    @Test
    fun getAFRICA() {
        assertEquals(3, maps.AFRICA)
    }

    @Test
    fun getEUROPE() {
        assertEquals(4, maps.EUROPE)
    }

    @Test
    fun getASIA() {
        assertEquals(5, maps.ASIA)
    }

    @Test
    fun getOCEANIA() {
        assertEquals(6, maps.OCEANIA)
    }

    @Test
    fun copy() {
        val maps2 = Maps()
        assertEquals(maps2, maps.copy())
    }

    @Test
    fun testToString() {
        assertEquals("Maps(NORTH_AMERICA=1, SOUTH_AMERICA=2, AFRICA=3, EUROPE=4, ASIA=5, OCEANIA=6)", maps.toString())
    }

    @Test
    fun testHashCode() {
        val maps2 = Maps()
        assertEquals(maps2.hashCode(), maps.hashCode())
    }

    @Test
    fun testEquals() {
        val maps2 = Maps()
        assertEquals(maps2, maps)
    }
}