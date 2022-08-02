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


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = RecipeRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }


    override fun getItemCount(): Int {
        return recipeList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = recipeList[position]
        holder.binding.idTxt.text = currentItem.id.toString()
        holder.binding.titleTxt.text = currentItem.name
        holder.binding.descriptionTxt.text = currentItem.description
    }

    fun setRecipeList(recipeList: List<RecipeEnt>) {
        this.recipeList = recipeList
    }

}