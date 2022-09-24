package com.example.scrapkitchen.ui.shoppingList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.scrapkitchen.R
import com.example.scrapkitchen.Util
import com.example.scrapkitchen.databinding.FragmentAddListFromRecipeBinding
import com.example.scrapkitchen.databinding.FragmentRecipeBinding
import com.example.scrapkitchen.db.entities.ShoppingItemEnt
import com.example.scrapkitchen.ui.recipe.RecipeListAdapter
import com.example.scrapkitchen.ui.recipe.RecipeViewModel

class AddListFromRecipeFragment : Fragment() {

    private val recipeViewModel: RecipeViewModel by activityViewModels { RecipeViewModel.Factory}
    private val shoppingListViewModel: ShoppingListViewModel by activityViewModels { ShoppingListViewModel.Factory  }

    private lateinit var binding: FragmentAddListFromRecipeBinding

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ShoppingListItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentBinding = FragmentAddListFromRecipeBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        adapter = ShoppingListItemAdapter(Util.ingredientsToList(recipeViewModel.getCurRecipe()!!.recipeShopping),shoppingListViewModel)
        recyclerView.adapter = adapter
        binding.addIngredToList.setOnClickListener {
            shoppingListViewModel.mergeItems(adapter.getItems())
            requireActivity().onBackPressed()
        }
        return fragmentBinding.root
    }

}