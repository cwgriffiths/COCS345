package com.example.recipeapp

import android.graphics.Color
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

/**
 * @author Cordell O'Leary
 */
abstract class SwipeGesture : ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT) {

    /**
     * Called when ItemTouchHelper wants to move the dragged item from its old position to
     * the new position.
     */
    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder,
    ): Boolean {
        return false
    }
}