package com.example.recipeapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeapp.AppDB
import com.example.recipeapp.ListAdapter
import com.example.recipeapp.R
import com.example.recipeapp.ShoppingListAdapter
import com.example.recipeapp.entities.ShoppingItemEnt

class ShoppingList:Fragment(R.layout.fragment_shopping_list) {

    private lateinit var recyclerView: RecyclerView
    private lateinit var items: List<ShoppingItemEnt>


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreate(savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_shopping_list, container, false)
        val adapter = ShoppingListAdapter(this, items)
        recyclerView = view.findViewById(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        items = AppDB.getInstance(view.context).shoppingItemDAO().getShoppingList()

        return view
    }

    fun onClick(ShoppingList: ShoppingItemEnt){


    }
}



