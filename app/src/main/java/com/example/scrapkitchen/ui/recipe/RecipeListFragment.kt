package com.example.scrapkitchen.ui.recipe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.scrapkitchen.R
import com.example.scrapkitchen.databinding.FragmentRecipeListBinding
import com.example.scrapkitchen.db.entities.RecipeEnt


class RecipeListFragment : Fragment(),RecipeListAdapter.OnRecipeSelected {

    private val recipeViewModel: RecipeViewModel by activityViewModels { RecipeViewModel.Factory}
    private lateinit var binding: FragmentRecipeListBinding

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecipeListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentBinding = FragmentRecipeListBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        recyclerView = binding.recipeRecycler
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        adapter = RecipeListAdapter(recipeViewModel.getRecipes(),recipeViewModel,this)
        recyclerView.adapter = adapter
        return fragmentBinding.root
    }



    override fun onRecipeSelected(recipe: RecipeEnt) {
        findNavController().navigate(R.id.action_recipeListFragment_to_recipeFragment)
    }

}