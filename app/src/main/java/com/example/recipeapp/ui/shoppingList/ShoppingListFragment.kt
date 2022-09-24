package com.example.scrapkitchen.ui.shoppingList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.coroutineScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeapp.R
import com.example.recipeapp.databinding.FragmentShoppingListBinding
import com.example.recipeapp.ui.shoppingList.AddShoppingItemFragment
import com.example.recipeapp.ui.shoppingList.ShoppingListViewModel

import kotlinx.coroutines.launch


class ShoppingListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CategoryAdapter


    private val shoppingListViewModel: ShoppingListViewModel by activityViewModels { ShoppingListViewModel.Factory  }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentShoppingListBinding.inflate(inflater)
        recyclerView = binding!!.shoppingListRecycle
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        shoppingListViewModel.items.observe(viewLifecycleOwner, Observer {
            adapter = CategoryAdapter(it,shoppingListViewModel)
            recyclerView.adapter = adapter
        })
        binding!!.addShoppingItem.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer,AddShoppingItemFragment() )
                .commit()
//            findNavController().navigate(R.id.action_navigation_shopping_list_to_navigate_addShoppingItem2)
        }
        return binding.root
    }

    override fun onPause() {
        super.onPause()
        lifecycle.coroutineScope.launch {
            shoppingListViewModel.removeChecked()
        }
    }

    override fun toString(): String {
        return "Shopping List"
    }

}