package com.example.recipeapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeapp.databinding.RecipeRowBinding
import com.example.recipeapp.entities.RecipeEnt

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var _binding: RecipeRowBinding? = null
    private val binding get() = _binding!!

    private var recipeList = emptyList<RecipeEnt>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {}


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        _binding = RecipeRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding.root)
    }


    override fun getItemCount(): Int {
        return recipeList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

    }

}