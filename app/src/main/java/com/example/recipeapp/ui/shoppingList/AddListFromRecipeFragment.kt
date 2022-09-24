package com.example.recipeapp.ui.shoppingList
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeapp.R
import com.example.recipeapp.Util
import com.example.recipeapp.databinding.FragmentAddListFromRecipeBinding
import com.example.recipeapp.ui.recipe.RecipeViewModel


class AddListFromRecipeFragment : Fragment() {

    private val recipeViewModel: RecipeViewModel by activityViewModels { RecipeViewModel.Factory}
    private val shoppingListViewModel: ShoppingListViewModel by activityViewModels { ShoppingListViewModel.Factory  }

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ShoppingListItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        val binding = inflater.inflate(R.layout.fragment_add_list_from_recipe, container, false)
        val binding = FragmentAddListFromRecipeBinding.inflate(inflater)

        recyclerView = binding.recyclerViewList
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        adapter = ShoppingListItemAdapter(Util.ingredientsToList(recipeViewModel.getCurRecipe()!!.recipeShopping),shoppingListViewModel)
        recyclerView.adapter = adapter
        binding.addIngredToList.setOnClickListener {
            shoppingListViewModel.mergeItems(adapter.getItems())
        }
        return binding.root
    }

}