package com.example.recipeapp.ui.mealPlanner

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.example.recipeapp.R
import com.example.recipeapp.ui.recipe.RecipeViewModel


class MealPlannerSelectDialog : DialogFragment() {

    private val mealPlannerViewModel: MealPlannerViewModel by activityViewModels { MealPlannerViewModel.Factory  }
    private val recipeViewModel: RecipeViewModel by activityViewModels { RecipeViewModel.Factory  }

    override fun onCreateDialog(savedInstanceState: Bundle?) : Dialog {
        return activity.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle(R.string.daySelector).setItems(R.array.Days, DialogInterface.OnClickListener {
                    dialog, which ->
                run {
                    mealPlannerViewModel.updateMealItem(recipeViewModel.getCurRecipe()!!.id,which)
                }
            })
            builder.create()
        }
    }

    companion object {
        const val TAG = "Select Day"
    }
}