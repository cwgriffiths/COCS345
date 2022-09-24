package com.example.scrapkitchen.ui.mealPlanner

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.coroutineScope
import com.example.scrapkitchen.R
import com.example.scrapkitchen.ui.recipe.RecipeViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


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