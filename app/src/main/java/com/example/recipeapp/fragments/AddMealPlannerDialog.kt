package com.example.recipeapp.fragments

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.recipeapp.AppDB
import com.example.recipeapp.R
import com.example.recipeapp.entities.RecipeEnt
import java.lang.IllegalStateException

/**
 * Class for adding an item to the meal planner popup
 */
class AddMealPlannerDialog(val recipe :RecipeEnt, private val applicationContext: Context) : DialogFragment() {
    private lateinit var db : AppDB

    /**
     * Creates the dialog
     */
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {

            val alertBuilder1 = AlertDialog.Builder(it)
            var checkedItemDay = 0
            alertBuilder1.setTitle("Select a day")
            alertBuilder1.setSingleChoiceItems(R.array.day, 0, DialogInterface.OnClickListener { _, index ->
                checkedItemDay = index
            })
            alertBuilder1.setPositiveButton("OK", DialogInterface.OnClickListener { _, _ -> addMealToTable(checkedItemDay, recipe)})
            alertBuilder1.setNegativeButton("Cancel", DialogInterface.OnClickListener { _, _ -> Log.d("DialogLog", "Cancelled") })




            alertBuilder1.create()

        } ?: throw IllegalStateException("Exception !! Activity is null !!")
    }

    /**
     * Adds the meal to the meal planner table
     */
    private fun addMealToTable(index:Int, recipe: RecipeEnt) {
        AppDB.getInstance(applicationContext).mealPlannerDAO().addToMealPlanner(index, recipe.id)
        Log.d("DialogLog",
            "Ok $index recipe id ${recipe.id}")
    }
}
