package com.example.recipeapp.ui.recipe

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeapp.db.AppDB
import com.example.recipeapp.R
import com.example.recipeapp.MainActivity
import com.example.recipeapp.RecipeDetailActivity
import com.example.recipeapp.db.entities.RecipeEnt

/**
 * Fragment to show list of recipes
 */
class Recipe(private val regionID: Int = -1):Fragment(), ListAdapter.OnItemClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var recipes : List<RecipeEnt>

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
        val adapter = ListAdapter(this)
        //Get a reference to the recycler view in the recipe fragment
        recyclerView = view.findViewById(R.id.recipeRecycler)
        //Set the layout manager for the recycler view
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
        MainActivity.setContinentID(regionID)
        //Try reading the data from the database
        recipes = if(regionID==-1) {
            AppDB.getInstance(view.context).recipeDAO().getRecipes()
        } else{
            AppDB.getInstance(view.context).recipeDAO().getRecipeByCountry(regionID)
        }
        adapter.setRecipeList(recipes)
        //Set the adapter on the recycler view


        return view
    }

    /**
     * This method is called when an item in the recycler view is clicked.
     * It starts the RecipeDetailActivity and passes the recipe ID to it.
     */
    override fun onItemClick(recipe: RecipeEnt) {

        val intent = Intent (context, RecipeDetailActivity()::class.java)
        intent.putExtra("recipe", recipe)
        startActivity(intent)
    }

    /**
     * Returns this instance as a string
     * Used to set the title of the view
     */
    override fun toString(): String {
        return "Recipes"
    }

}