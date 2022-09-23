package com.example.recipeapp.db.dao

import com.example.recipeapp.consts.Constants
import org.junit.Assert.*

import org.junit.Test

/**
 * @author Conor Griffiths
 */
class ConstantsTest {

    private val constants = Constants()

    /**
     * Asserts that get North America returns the appropriate value
     */
    @Test
    fun getNORTH_AMERICA() {
        assertEquals(1, constants.NORTH_AMERICA)
    }

    /**
     * Asserts that get South America returns the appropriate value
     */
    @Test
    fun getSOUTH_AMERICA() {
        assertEquals(2, constants.SOUTH_AMERICA)
    }

    /**
     * Asserts that get Africa returns the appropriate value
     */
    @Test
    fun getAFRICA() {
        assertEquals(3, constants.AFRICA)
    }

    /**
     * Asserts that get Europe returns the appropriate value
     */
    @Test
    fun getEUROPE() {
        assertEquals(4, constants.EUROPE)
    }

    /**
     * Asserts that get Asia returns the appropriate value
     */
    @Test
    fun getASIA() {
        assertEquals(5, constants.ASIA)
    }

    /**
     * Asserts that get Oceania returns the appropriate value
     */
    @Test
    fun getOCEANIA() {
        assertEquals(6, constants.OCEANIA)
    }

    /**
     * Tests the data class copy function is working properly
     */
    @Test
    fun copy() {
        val constants2 = Constants()
        assertEquals(constants2, constants.copy())
    }

    /**
     * Tests the data class toString function is working properly
     */
    @Test
    fun testToString() {
        assertEquals("Maps(NORTH_AMERICA=1, SOUTH_AMERICA=2, AFRICA=3, EUROPE=4, ASIA=5, OCEANIA=6)", constants.toString())
    }

    /**
     * Tests the data class hashCode function is working properly
     */
    @Test
    fun testHashCode() {
        val constants2 = Constants()
        assertEquals(constants2.hashCode(), constants.hashCode())
    }

    /**
     * Tests the data class equals function is working properly
     */
    @Test
    fun testEquals() {
        val constants2 = Constants()
        assertEquals(constants2, constants)
    }
}