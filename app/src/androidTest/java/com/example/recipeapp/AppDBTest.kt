package com.example.recipeapp

import android.content.Context
import androidx.room.Room
import androidx.room.Room.inMemoryDatabaseBuilder
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.recipeapp.dao.ShoppingItemEntDAO
import com.example.recipeapp.entities.ShoppingItemEnt
import junit.framework.TestCase
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runner.manipulation.Ordering
import org.junit.runners.JUnit4

@RunWith(AndroidJUnit4::class)
class AppDBTest : TestCase(){

    private lateinit var db: AppDB
    private lateinit var dao: ShoppingItemEntDAO

    @Before
    public override fun setUp() {
        super.setUp()
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = inMemoryDatabaseBuilder(context, AppDB::class.java).build()
        dao = db.shoppingItemDAO()
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


    }

}