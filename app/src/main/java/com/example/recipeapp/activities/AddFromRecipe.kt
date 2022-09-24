package com.example.recipeapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeapp.R
import com.example.recipeapp.Util
import com.example.recipeapp.databinding.ActivityAddFromRecipeBinding
import com.example.recipeapp.db.entities.RecipeEnt
import com.example.recipeapp.ui.recipe.RecipeViewModel
import com.example.recipeapp.ui.shoppingList.ShoppingListItemAdapter
import com.example.recipeapp.ui.shoppingList.ShoppingListViewModel

class AddFromRecipe : AppCompatActivity() {
    private lateinit var recipe: RecipeEnt
    private val shoppingListViewModel: ShoppingListViewModel by viewModels { ShoppingListViewModel.Factory  }

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ShoppingListItemAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipe = intent.getParcelableExtra("recipe2")!!
        shoppingListViewModel.items.observe(this, Observer {
            println(it)
        })
        val binding = ActivityAddFromRecipeBinding.inflate(layoutInflater)
        recyclerView = binding.recyclerViewList
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        adapter = ShoppingListItemAdapter(Util.ingredientsToList(recipe.recipeShopping),shoppingListViewModel)
        recyclerView.adapter = adapter
        binding.addIngredToList.setOnClickListener {
            shoppingListViewModel.mergeItems(adapter.getItems())
            finish()
        }
        setContentView(binding.root)

    }
}