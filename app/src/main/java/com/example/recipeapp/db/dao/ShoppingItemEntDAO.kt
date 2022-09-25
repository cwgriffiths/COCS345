package com.example.recipeapp.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.recipeapp.db.entities.ShoppingItemEnt
import kotlinx.coroutines.flow.Flow


@Dao
interface ShoppingItemEntDAO {
    @Query("SELECT * FROM item_table")
    fun getShoppingList() : Flow<List<ShoppingItemEnt>>

    @Query("DELETE FROM item_table where checked = 1")
    fun removedChecked()

    @Query("SELECT * FROM item_table where id = (:id)")
    fun getItem(id: Int) : ShoppingItemEnt

    @Insert
    fun addItem(item : ShoppingItemEnt)

    @Update
    fun updateItem(item: ShoppingItemEnt)

    @Query("UPDATE item_table SET checked = (:check) WHERE id = (:id)")
    fun checkItem(id : Int, check : Boolean)
}