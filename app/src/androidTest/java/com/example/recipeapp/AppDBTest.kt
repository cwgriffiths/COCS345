package com.example.recipeapp

import android.content.Context
import androidx.room.Room
import androidx.room.Room.inMemoryDatabaseBuilder
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.recipeapp.dao.RecipeEntDAO
import com.example.recipeapp.dao.ShoppingItemEntDAO
import com.example.recipeapp.entities.RecipeEnt
import com.example.recipeapp.entities.ShoppingItemEnt
import junit.framework.TestCase
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runner.manipulation.Ordering
import org.junit.runners.JUnit4
import java.util.stream.Stream

@RunWith(AndroidJUnit4::class)
class AppDBTest : TestCase(){

    private lateinit var db: AppDB
    private lateinit var dao: ShoppingItemEntDAO
    private lateinit var daoRecipe: RecipeEntDAO

    @Before
    public override fun setUp() {
        super.setUp()
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = inMemoryDatabaseBuilder(context, AppDB::class.java).build()
        dao = db.shoppingItemDAO()
        daoRecipe = db.recipeDAO()
    }

    @After
    fun closeUp(){
        db.close()
    }

    @Test
    fun writeAndReadItem(){

        val item = ShoppingItemEnt(item = "milk", id = 3, amount = 1, metric = "cup", checked = false, cat = "dairy")
        dao.addItem(item)
        val worked = dao.getShoppingList()
        if(worked.isNotEmpty()){
            assertEquals(item.id, worked[0].id)        }

    }

    @Test
    fun writeAndReadRecipe(){

        val recpie = RecipeEnt(id = 2, name = "apps suck", description = "this sucks", region = 3, ingredients = "5 apples", method = "cook appples", servings = 5, country = "America", recipeShopping = "apples, milk, sugar")
        daoRecipe.insertRecipe(recpie)
        val check = daoRecipe.getRecipeById(2)
        if (check.id == 2){
            assertEquals(recpie.id, check.id)
        }
        val check2 = daoRecipe.getRecipeByCountry(3)
        val recp = daoRecipe.getRecipes()
        assertEquals(recpie.country, check2[0].country)
        assertFalse(recp.isEmpty())

    }

}