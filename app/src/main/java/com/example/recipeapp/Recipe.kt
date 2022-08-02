package com.example.recipeapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeapp.dao.RecipeEntDAO

class Recipe:Fragment(R.layout.fragment_recipe){

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //Get a reference to the recycler view in the recipe fragment
        recyclerView = view?.findViewById(R.id.recipeRecycler) ?: return view
        recyclerView.layoutManager = LinearLayoutManager(requireView().context);
        val adapter = ListAdapter()
        val recipes = AppDB.getInstance(requireView().context).recipeDAO().getRecipes()
        adapter.setRecipeList(recipes)
        recyclerView.adapter = adapter

        return recyclerView
    }

}