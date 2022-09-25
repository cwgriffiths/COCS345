package com.example.recipeapp.db.repos

import androidx.annotation.WorkerThread
import com.example.recipeapp.db.dao.ShoppingItemEntDAO
import com.example.recipeapp.db.entities.ShoppingItemEnt
import kotlinx.coroutines.flow.Flow

class ShoppingItemRepo(private val dao: ShoppingItemEntDAO) {
    private val items: Flow<List<ShoppingItemEnt>> = dao.getShoppingList()

    fun getShoppingList(): Flow<List<ShoppingItemEnt>> {
        return items
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    fun removedChecked() {
        dao.removedChecked()
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    fun getItem(id: Int): ShoppingItemEnt {
        return dao.getItem(id)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    fun addItem(item: ShoppingItemEnt) {
        dao.addItem(item)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    fun checkItem(id: Int, check: Boolean) {
        dao.checkItem(id, check)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    fun updateItem(item: ShoppingItemEnt) {
        dao.updateItem(item)
    }
}