package com.example.recipeapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Recipe:Fragment(){

    private lateinit var recyclerView: RecyclerView

    /**
     * This method is called when the fragment is created.
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_recipe, container, false)
        val adapter = ListAdapter()
        //Get a reference to the recycler view in the recipe fragment
        recyclerView = view.findViewById(R.id.recipeRecycler)
        //Set the layout manager for the recycler view
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        //Try reading the data from the database
        val recipes = AppDB.getInstance(view.context).recipeDAO().getRecipes()
        adapter.setRecipeList(recipes)
        //Set the adapter on the recycler view


        return view
    }

}