package com.example.recipeapp.db.repos

import androidx.annotation.WorkerThread
import com.example.recipeapp.db.dao.MealPlannerEntDAO
import com.example.recipeapp.db.entities.MealPlannerEnt

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