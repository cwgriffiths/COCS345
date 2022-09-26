package com.example.recipeapp.ui.shoppingList

import android.graphics.Color
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

/**
 * Class to allow swipe actions
 * @author Ariana,Conor,Cordell,Derek
 * */
abstract class SwipeGesture : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {

    /**
     * handles what happens when you move a view
     * */
    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder,
    ): Boolean {
        return false
    }

    /**
     * handles what happens when you swipe a view
     * */
    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        if (direction == ItemTouchHelper.LEFT) {
            viewHolder.itemView.setBackgroundColor(Color.RED)
        }
    }
}