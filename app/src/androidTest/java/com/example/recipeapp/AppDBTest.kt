package com.example.recipeapp

import android.content.Context
import androidx.room.Room.inMemoryDatabaseBuilder
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.recipeapp.db.AppDB
import com.example.recipeapp.db.dao.RecipeEntDAO
import com.example.recipeapp.db.dao.ShoppingItemEntDAO
import com.example.recipeapp.db.entities.RecipeEnt
import com.example.recipeapp.db.entities.ShoppingItemEnt
import junit.framework.TestCase
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author Conor Griffiths
 */
@RunWith(AndroidJUnit4::class)
class AppDBTest : TestCase(){

    private lateinit var db: AppDB
    private lateinit var dao: ShoppingItemEntDAO
    private lateinit var daoRecipe: RecipeEntDAO

    /**
     * Setup the database and the DAO for testing
     */
    @Before
    public override fun setUp() {
        super.setUp()
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = inMemoryDatabaseBuilder(context, AppDB::class.java).build()
        dao = db.shoppingItemDAO()
        daoRecipe = db.recipeDAO()
    }

    /**
     * Close the database after testing
     */
    @After
    fun closeUp(){
        db.close()
    }

    /**
     * Test the insert and get all functions of the DAO

    @Test
    fun writeAndReadItem(){

        val item = ShoppingItemEnt(item = "milk", id = 3, amount = 1.0, metric = "cup", checked = false, cat = "dairy")
        dao.addItem(item)
        val worked = dao.getShoppingList()
        if(worked.isNotEmpty()){
            assertEquals(item.id, worked[0].id)        }

    }
    */

    @Test
    /**
     * Test the insert and get all functions of the DAO
     */
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