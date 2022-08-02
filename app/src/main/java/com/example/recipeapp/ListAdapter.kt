package com.example.recipeapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeapp.databinding.RecipeRowBinding
import com.example.recipeapp.entities.RecipeEnt

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {


    private var recipeList = emptyList<RecipeEnt>()

    inner class MyViewHolder(val binding: RecipeRowBinding): RecyclerView.ViewHolder(binding.root) {
    }

    /**
     * Creates and returns a new ViewHolder object with a reference to the view binding
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = RecipeRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }


    override fun getItemCount(): Int {
        return recipeList.size
    }

    /**
     * Called by RecyclerView to display the data at the specified position.
     */
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = recipeList[position]
        //Sets the text fields of the recipe list item
        holder.binding.idTxt.text = currentItem.id.toString()
        holder.binding.titleTxt.text = currentItem.name
        holder.binding.descriptionTxt.text = currentItem.description
    }

    /**
     * Sets the list of recipes to be displayed
     */
    fun setRecipeList(recipeList: List<RecipeEnt>) {
        this.recipeList = recipeList
    }

}