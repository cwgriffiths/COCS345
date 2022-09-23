package com.example.recipeapp.dao

import org.junit.Assert.*

import org.junit.Test

class MapsTest {

    private val maps = Maps()

    /**
     * Asserts that get North America returns the appropriate value
     */
    @Test
    fun getNORTH_AMERICA() {
        assertEquals(1, maps.NORTH_AMERICA)
    }

    /**
     * Asserts that get South America returns the appropriate value
     */
    @Test
    fun getSOUTH_AMERICA() {
        assertEquals(2, maps.SOUTH_AMERICA)
    }

    /**
     * Asserts that get Africa returns the appropriate value
     */
    @Test
    fun getAFRICA() {
        assertEquals(3, maps.AFRICA)
    }

    /**
     * Asserts that get Europe returns the appropriate value
     */
    @Test
    fun getEUROPE() {
        assertEquals(4, maps.EUROPE)
    }

    /**
     * Asserts that get Asia returns the appropriate value
     */
    @Test
    fun getASIA() {
        assertEquals(5, maps.ASIA)
    }

    /**
     * Asserts that get Oceania returns the appropriate value
     */
    @Test
    fun getOCEANIA() {
        assertEquals(6, maps.OCEANIA)
    }

    /**
     * Tests the data class copy function is working properly
     */
    @Test
    fun copy() {
        val maps2 = Maps()
        assertEquals(maps2, maps.copy())
    }

    /**
     * Tests the data class toString function is working properly
     */
    @Test
    fun testToString() {
        assertEquals("Maps(NORTH_AMERICA=1, SOUTH_AMERICA=2, AFRICA=3, EUROPE=4, ASIA=5, OCEANIA=6)", maps.toString())
    }

    /**
     * Tests the data class hashCode function is working properly
     */
    @Test
    fun testHashCode() {
        val maps2 = Maps()
        assertEquals(maps2.hashCode(), maps.hashCode())
    }

    /**
     * Tests the data class equals function is working properly
     */
    @Test
    fun testEquals() {
        val maps2 = Maps()
        assertEquals(maps2, maps)
    }
}