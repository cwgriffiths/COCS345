package com.example.scrapkitchen.ui.mealPlanner

import android.app.Application
import androidx.lifecycle.*
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.scrapkitchen.db.AppDB
import com.example.scrapkitchen.db.entities.MealPlannerEnt
import com.example.scrapkitchen.db.entities.RecipeEnt
import com.example.scrapkitchen.db.entities.ShoppingItemEnt
import com.example.scrapkitchen.db.repos.MealPlannerRepo
import com.example.scrapkitchen.db.repos.ShoppingItemRepo
import com.example.scrapkitchen.ui.shoppingList.ShoppingListViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MealPlannerViewModel(private val repo: MealPlannerRepo) : ViewModel() {
    var items: LiveData<List<MealPlannerEnt>> = repo.getMealPlanner().asLiveData()
    var weekRecipes : MutableList<RecipeEnt> = mutableListOf()

    fun updateMealItem(recipeId: Int,index:Int){
        repo.updateMealPlanner(recipeId, index)
    }
    companion object {

        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                // Get the Application object from extras
                val application = checkNotNull(extras[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY])
                // Create a SavedStateHandle for this ViewModel from extras
                val repo = MealPlannerRepo(AppDB.getInstance(application.applicationContext).mealPlannerDAO())
                val savedStateHandle = extras.createSavedStateHandle()

                return MealPlannerViewModel(
                    (repo as MealPlannerRepo)
                ) as T
            }
        }
    }
}