package com.example.recipeapp.ui.shoppingList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.coroutineScope
import com.example.recipeapp.R
import com.example.recipeapp.databinding.FragmentAddShoppingItemBinding
import com.example.recipeapp.db.entities.ShoppingItemEnt
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AddShoppingItemFragment : Fragment() {

    private val shoppingListViewModel: ShoppingListViewModel by activityViewModels { ShoppingListViewModel.Factory  }
    private var binding: FragmentAddShoppingItemBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentAddShoppingItemBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        binding!!.submit.setOnClickListener {
            addItem()
            requireActivity().onBackPressed()
        }
        return fragmentBinding.root
    }

    private fun addItem(){
        val name = view?.findViewById<EditText>(R.id.name)?.text.toString()
        val category = view?.findViewById<Spinner>(R.id.category)?.selectedItem.toString()
        val metric = view?.findViewById<Spinner>(R.id.metric)?.selectedItem.toString()
        val amount = view?.findViewById<EditText>(R.id.amount)?.text.toString()
        val ent = ShoppingItemEnt(0,name,amount.toDouble(),metric,false,category)
        shoppingListViewModel.addItem(ent)
    }

}