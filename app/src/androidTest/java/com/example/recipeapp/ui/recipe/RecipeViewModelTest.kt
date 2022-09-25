package com.example.recipeapp.ui.recipe

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.recipeapp.db.AppDB
import com.example.recipeapp.db.entities.RecipeEnt
import com.example.recipeapp.db.repos.RecipeRepo
import junit.framework.TestCase
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RecipeViewModelTest : TestCase() {

    private lateinit var viewModel: RecipeViewModel
    private val testRecipe = RecipeEnt(0,"Pie","Yummy Pie",1,"Pie ingredients","Cook in oven",4,"NZ","1, Whole, pantry, Pie")


    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    public override fun setUp() {
        super.setUp()
        val context = ApplicationProvider.getApplicationContext<Context>()
        val db = Room.inMemoryDatabaseBuilder(context, AppDB::class.java).allowMainThreadQueries().build()
        val dao = db.recipeDAO()
        dao.insertRecipe(testRecipe)
        viewModel = RecipeViewModel(RecipeRepo(dao))
    }


    @Test
    fun setCurRecipe() {
        assertEquals(viewModel.getCurRecipe(),null)
        viewModel.setCurRecipe(testRecipe)
        assertEquals(viewModel.getCurRecipe(),testRecipe)
    }

    @Test
    fun getCurRecipe() {
        viewModel.setCurRecipe(testRecipe)
        assertEquals(viewModel.getCurRecipe(),testRecipe)
    }

    @Test
    fun getRecipes() {
        assert(viewModel.getRecipes().contains(testRecipe))
    }

    @Test
    fun getRecipeById() {
        assertEquals(viewModel.getRecipeById(0),testRecipe)
    }
}