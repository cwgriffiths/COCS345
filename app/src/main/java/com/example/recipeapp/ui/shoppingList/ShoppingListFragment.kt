package com.example.recipeapp.ui.shoppingList

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
import kotlinx.coroutines.launch


class ShoppingListFragment : Fragment() {

    private var binding: FragmentShoppingListBinding? = null
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CategoryAdapter


    private val shoppingListViewModel: ShoppingListViewModel by activityViewModels { ShoppingListViewModel.Factory }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentBinding = FragmentShoppingListBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        recyclerView = binding!!.shoppingListRecycle
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        shoppingListViewModel.items.observe(viewLifecycleOwner) {
            adapter = CategoryAdapter(it, shoppingListViewModel)
            recyclerView.adapter = adapter
        }
        binding!!.addShoppingItem.setOnClickListener {
            findNavController().navigate(R.id.action_shoppingListFragment_to_addShoppingItemFragment)
        }
        return fragmentBinding.root
    }

    override fun onPause() {
        super.onPause()
        lifecycle.coroutineScope.launch {
            shoppingListViewModel.removeChecked()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}