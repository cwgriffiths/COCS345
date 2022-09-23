package com.example.recipeapp.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.recipeapp.entities.ShoppingItemEnt

/**
 * Defines methods for using the ShoppingItemEnt class with Room.
 */
@Dao
interface ShoppingItemEntDAO {

    /**
     * Get the entire shopping list
     */
    @Query("SELECT * FROM item_table")
    fun getShoppingList() : List<ShoppingItemEnt>

    /**
     * Remove all checked items from the shopping list table
     */
    @Query("DELETE FROM item_table where checked = 1")
    fun removedChecked()

    /**
     * Get specific item from the shopping list table
     */
    @Query("SELECT * FROM item_table where id = (:id)")
    fun getItem(id: Int) : ShoppingItemEnt

    /**
     * Insert a new item into the shopping list table
     */
    @Insert
    fun addItem(item : ShoppingItemEnt)

    /**
     * Update an item in the shopping list table so that status is checked
     */
    @Query("UPDATE item_table SET checked = (:check) WHERE id = (:id)")
    fun checkItem(id : Int, check : Boolean)
}