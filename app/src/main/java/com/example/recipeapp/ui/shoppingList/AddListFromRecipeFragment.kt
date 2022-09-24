package com.example.recipeapp.ui.shoppingList
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeapp.R
import com.example.recipeapp.ui.shoppingList.SItemAdapter


class AddListFromRecipeFragment : Fragment() {



    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: SItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = inflater.inflate(R.layout.fragment_add_list_from_recipe, container, false)

        recyclerView = binding.findViewById(R.id.recyclerViewList)
        recyclerView.layoutManager = LinearLayoutManager(this.context)
//        adapter = SItemAdapter()
        recyclerView.adapter = adapter
        binding.findViewById<Button>(R.id.addIngredToList).setOnClickListener {
//            shoppingListViewModel.mergeItems(adapter.getItems())
        }
        return binding
    }

}