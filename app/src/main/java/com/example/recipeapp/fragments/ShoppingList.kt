package com.example.recipeapp.fragments

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.recipeapp.R
import com.example.recipeapp.activities.AddShoppingItem

class ShoppingList:Fragment(R.layout.fragment_shopping_list) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_add_item,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_add_item -> {
                startActivity(Intent(requireActivity(), AddShoppingItem::class.java))
                true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}