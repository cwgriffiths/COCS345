package com.example.recipeapp.ui.mealPlanner

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.recipeapp.db.AppDB
import com.example.recipeapp.db.entities.MealPlannerEnt
import com.example.recipeapp.db.repos.MealPlannerRepo
import com.example.scrapkitchen.getOrAwaitValue
import junit.framework.TestCase
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MealPlannerViewModelTest : TestCase(){
    private lateinit var viewModel: MealPlannerViewModel
    private val mealPlannerData = listOf<MealPlannerEnt>(MealPlannerEnt(0,0), MealPlannerEnt(1,1),MealPlannerEnt(2,2),MealPlannerEnt(3,3),MealPlannerEnt(4,4),MealPlannerEnt(5,5),MealPlannerEnt(6,6))

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    public override fun setUp() {
        super.setUp()
        val context = ApplicationProvider.getApplicationContext<Context>()
        val db = Room.inMemoryDatabaseBuilder(context, AppDB::class.java).allowMainThreadQueries().build()
        val dao = db.mealPlannerDAO()
        dao.setMealPlanner(mealPlannerData)
        viewModel = MealPlannerViewModel(MealPlannerRepo(dao))
    }

    @Test
    fun updateMealItem() {
        viewModel.updateMealItem(15555,0)
        val newEnt = MealPlannerEnt(0,15555)
        val result = viewModel.items.getOrAwaitValue().contains(newEnt)
        assert(result)
    }

}