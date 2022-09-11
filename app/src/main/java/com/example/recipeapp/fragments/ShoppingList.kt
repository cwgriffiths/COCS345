package com.example.recipeapp.fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.CheckBox
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeapp.*
import com.example.recipeapp.activities.AddShoppingItem
import com.example.recipeapp.entities.RecipeEnt
import com.example.recipeapp.entities.ShoppingItemEnt

class ShoppingList:Fragment(R.layout.fragment_shopping_list),SItemAdapter.OnItemCheckListener {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CategoryAdapter
    private lateinit var items : List<ShoppingItemEnt>
    private lateinit var db : AppDB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_add_item,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_add_item -> {
                var intent: Intent = Intent(requireActivity(), AddShoppingItem::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        db = AppDB.getInstance(view.context)
        items = db.shoppingItemDAO().getShoppingList()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.shoppingListRecycle)
        recyclerView.layoutManager = layoutManager
        adapter = CategoryAdapter(Util.mapByProp(items),this)
        recyclerView.adapter = adapter
    }

    override fun onItemCheck(item: ShoppingItemEnt) {
        db.shoppingItemDAO().checkItem(item.id,!item.checked)
    }

    override fun onPause() {
        db.shoppingItemDAO().removedChecked()
        super.onPause()
    }

    override fun onResume() {
        items = db.shoppingItemDAO().getShoppingList()
        adapter = CategoryAdapter(Util.mapByProp(items),this)
        recyclerView.adapter = adapter
        super.onResume()
    }

    override fun toString(): String {
        return "Shopping List"
    }

}