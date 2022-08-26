package com.example.recipeapp.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.recipeapp.entities.ShoppingItemEnt

@Dao
interface ShoppingItemEntDAO {
    @Query("SELECT * FROM item_table")
    fun getShoppingList() : List<ShoppingItemEnt>

    @Query("DELETE FROM item_table where checked = 1")
    fun removedChecked()

    @Insert
    fun addItem(item : ShoppingItemEnt)

    @Query("UPDATE item_table SET checked = (:check) WHERE id = (:id)")
    fun checkItem(id : Int, check : Boolean)
}