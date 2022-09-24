package com.example.recipeapp.ui.shoppingList

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeapp.*
import com.example.recipeapp.activities.AddShoppingItem
import com.example.recipeapp.db.AppDB
import com.example.recipeapp.db.entities.ShoppingItemEnt

/**
 * Fragment for the shopping list
 * One of three main views within the app
 */
class ShoppingList:Fragment(R.layout.fragment_shopping_list), SItemAdapter.OnItemCheckListener {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CategoryAdapter
    private lateinit var items : List<ShoppingItemEnt>
    private lateinit var db : AppDB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    /**
     * Adds the option menu to the tob bar
     */
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_add_item,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    /**
     * Handles the click on the menu item
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_add_item -> {
                val intent = Intent(requireActivity(), AddShoppingItem::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    /**
     * Inflates the view and sets the recycler view
     */
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

    /**
     * Event when item is checcked
     */
    override fun onItemCheck(item: ShoppingItemEnt) {
        item.checked = !item.checked
        db.shoppingItemDAO().checkItem(item.id,item.checked)
    }

    /**
     * Event when item is swiped, deletes the item
     */
    override fun onItemSwipe(item: ShoppingItemEnt) {
        db.shoppingItemDAO().checkItem(item.id,true)
        db.shoppingItemDAO().removedChecked()
        items = db.shoppingItemDAO().getShoppingList()
        adapter = CategoryAdapter(Util.mapByProp(items),this)
        recyclerView.adapter = adapter
    }

    /**
     * Event when fragment is paused, deletes the checked items
     */
    override fun onPause() {
        db.shoppingItemDAO().removedChecked()
        super.onPause()
    }

    /**
     * Refreshes on resume
     */
    override fun onResume() {
        items = db.shoppingItemDAO().getShoppingList()
        adapter = CategoryAdapter(Util.mapByProp(items),this)
        recyclerView.adapter = adapter
        super.onResume()
    }

    /**
     * Names the fragment
     */
    override fun toString(): String {
        return "Shopping List"
    }

}