package com.example.recipeapp.fragments

import android.view.View
import androidx.fragment.app.FragmentManager
import com.example.recipeapp.ui.mealPlanner.MealPlanner
import org.junit.Assert.*

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

/**
 * Tests for the region select fragent
 */
@RunWith(MockitoJUnitRunner::class)
class MealPlannerTest {

    @Mock
    private lateinit var view : View

    @Mock
    lateinit var supportFragmentManager : FragmentManager

    /**
     * Test the toString method
     */

    @Test
    fun onClick(){
        val mealPlanner = MealPlanner()
        val result = mealPlanner.onOptionsItemSelected(Mockito.mock(android.view.MenuItem::class.java))
        assertFalse(result)
    }
}