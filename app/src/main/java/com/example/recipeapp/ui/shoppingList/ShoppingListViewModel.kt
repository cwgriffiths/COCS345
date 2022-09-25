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
        newItems.forEach { newItem ->
            if (newItem.checked) {
                var add = true
                items.value!!.forEach {
                    val curItem = it
                    if (newItem.item.lowercase() == curItem.item.lowercase() && add) {
                        curItem.amount += newItem.amount
                        add = false
                        updateItem(curItem)
                    }
                }
                if (add) {
                    newItem.checked = false
                    when (newItem.cat.lowercase().trim()) {
                        "produce" -> {
                            newItem.cat = "Produce \uD83C\uDF4E"
                        }
                        "meats&seafood" -> {
                            newItem.cat = "Meats & Seafood \uD83C\uDF57"
                        }
                        "baking goods" -> {
                            newItem.cat = "Baking Goods \uD83E\uDDC8"
                        }
                        "frozen" -> {
                            newItem.cat = "Frozen \uD83C\uDF66"
                        }
                        "pantry" -> {
                            newItem.cat = "Pantry \uD83C\uDF6B"
                        }
                        "bakery" -> {
                            newItem.cat = "Bakery \uD83C\uDF5E"
                        }
                        "dairy" -> {
                            newItem.cat = "Dairy \uD83E\uDD5B"
                        }
                    }
                    addItem(newItem)
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