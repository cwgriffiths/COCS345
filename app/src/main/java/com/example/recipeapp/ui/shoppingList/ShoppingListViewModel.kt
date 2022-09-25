package com.example.recipeapp.ui.shoppingList

import androidx.lifecycle.*
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.recipeapp.db.AppDB
import com.example.recipeapp.db.entities.ShoppingItemEnt
import com.example.recipeapp.db.repos.ShoppingItemRepo


class ShoppingListViewModel(private val repo: ShoppingItemRepo) : ViewModel() {
    var items: LiveData<List<ShoppingItemEnt>> = repo.getShoppingList().asLiveData()

    fun addItem(item: ShoppingItemEnt) {
        repo.addItem(item)
    }

    fun removeItem(item: ShoppingItemEnt) {
        repo.checkItem(item.id, true)
        repo.removedChecked()
    }

    fun checkItem(item: ShoppingItemEnt) {

        item.checked = !item.checked
        repo.checkItem(item.id, item.checked)
    }

    fun removeChecked() {
        repo.removedChecked()
    }

    fun mergeItems(newItems: List<ShoppingItemEnt>) {
//        Could make this faster with a hash map but too lazy some in doing a double for loop
        newItems.forEach {
            if (it.checked) {
                var add = true
                val item = it
                items.value!!.forEach {
                    val curItem = it
                    if (item.item.lowercase() == curItem.item.lowercase() && add) {
                        curItem.amount += item.amount
                        add = false
                        updateItem(curItem)
                    }
                }
                if (add) {
                    item.checked = false
                    val cat = item.cat.lowercase().trim()
                    if (cat == "produce") {
                        item.cat = "Produce \uD83C\uDF4E"
                    } else if (cat == "meats&seafood") {
                        item.cat = "Meats & Seafood \uD83C\uDF57"
                    } else if (cat == "baking goods") {
                        item.cat = "Baking Goods \uD83E\uDDC8"
                    } else if (cat == "frozen") {
                        item.cat = "Frozen \uD83C\uDF66"
                    } else if (cat == "pantry") {
                        item.cat = "Pantry \uD83C\uDF6B"
                    } else if (cat == "bakery") {
                        item.cat = "Bakery \uD83C\uDF5E"
                    } else if (cat == "dairy") {
                        item.cat = "Dairy \uD83E\uDD5B"
                    }
                    addItem(item)
                }
            }
        }
    }

    private fun updateItem(item: ShoppingItemEnt) {
        repo.updateItem(item)
    }


    companion object {

        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                // Get the Application object from extras
                val application =
                    checkNotNull(extras[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY])
                // Create a SavedStateHandle for this ViewModel from extras
                val savedStateHandle = extras.createSavedStateHandle()
                val repo = ShoppingItemRepo(
                    AppDB.getInstance(application.applicationContext).shoppingItemDAO()
                )

                return ShoppingListViewModel(
                    (repo)
                ) as T
            }
        }
    }

}