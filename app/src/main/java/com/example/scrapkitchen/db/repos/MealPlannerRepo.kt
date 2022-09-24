package com.example.scrapkitchen.db.repos

import androidx.annotation.WorkerThread
import com.example.scrapkitchen.db.dao.MealPlannerEntDAO
import com.example.scrapkitchen.db.dao.ShoppingItemEntDAO
import com.example.scrapkitchen.db.entities.MealPlannerEnt
import kotlinx.coroutines.flow.Flow

class MealPlannerRepo(private val dao: MealPlannerEntDAO) {
    private val mealPlanner : Flow<List<MealPlannerEnt>> = dao.getMealPlanner()
    fun getMealPlanner(): Flow<List<MealPlannerEnt>>{
        return mealPlanner
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    fun updateMealPlanner(recipeId:Int,index:Int){
        dao.updateMealPlanner(recipeId,index);
    }
}