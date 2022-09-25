package com.example.recipeapp.ui.shoppingList

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.recipeapp.db.AppDB
import com.example.recipeapp.db.entities.ShoppingItemEnt
import com.example.recipeapp.db.repos.ShoppingItemRepo
import com.example.recipeapp.getOrAwaitValue
import junit.framework.TestCase
import org.junit.Before
import org.junit.Rule

import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ShoppingListViewModelTest : TestCase() {

    private lateinit var viewModel: ShoppingListViewModel

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    public override fun setUp() {
        super.setUp()
        val context = ApplicationProvider.getApplicationContext<Context>()
        val db = Room.inMemoryDatabaseBuilder(context, AppDB::class.java).allowMainThreadQueries().build()
        val dao = db.shoppingItemDAO()
        dao.addItem(ShoppingItemEnt(2,"Apples",2.0,"kg",false,"Fruit"))

        viewModel = ShoppingListViewModel(ShoppingItemRepo(dao))
    }

    @Test
    fun addItem() {
        val item = ShoppingItemEnt(1,"Cheese",2.0,"kg",false,"Dairy")
        viewModel.addItem(item)
        val result = viewModel.items.getOrAwaitValue().contains(item)
        assert(result)
    }

    @Test
    fun removeItem() {
        val item = ShoppingItemEnt(1,"Cheese",2.0,"kg",false,"Dairy")
        viewModel.addItem(item)
        val itemsAdd = viewModel.items.getOrAwaitValue()
        val fetchItem = itemsAdd.get(itemsAdd.indexOf(item))
        viewModel.removeItem(fetchItem)
        val items = viewModel.items.getOrAwaitValue()
        assert(!items.contains(fetchItem))
    }

    @Test
    fun checkItem() {
        val item = ShoppingItemEnt(1,"Cheese",2.0,"kg",false,"Dairy")
        viewModel.addItem(item)
        val itemsAdd = viewModel.items.getOrAwaitValue()
        val fetchItem = itemsAdd.get(itemsAdd.indexOf(item))
        viewModel.checkItem(fetchItem)
        item.checked = !item.checked
        val items = viewModel.items.getOrAwaitValue()
        assert(items.contains(item))
    }

    @Test
    fun removeChecked() {
        val item = ShoppingItemEnt(1,"Cheese",2.0,"kg",true,"Dairy")
        viewModel.addItem(item)
        viewModel.removeChecked()
        val items = viewModel.items.getOrAwaitValue()
        assert(!items.contains(item))
    }

    @Test
    fun mergeItems() {
        val itemsToMerge : List<ShoppingItemEnt> = listOf(ShoppingItemEnt(1,"Apples",3.0,"kg",true,"Fruit"))
        val expectedAmount = 5.0
        val items = viewModel.items.getOrAwaitValue()
        viewModel.mergeItems(itemsToMerge)

        val fetchItem = viewModel.items.getOrAwaitValue().find{
            it.item == itemsToMerge[0].item && it.cat == itemsToMerge[0].cat && it.metric == itemsToMerge[0].metric
        }
//        println(viewModel.items.getOrAwaitValue())
        assert(fetchItem!!.amount == expectedAmount)

    }
}