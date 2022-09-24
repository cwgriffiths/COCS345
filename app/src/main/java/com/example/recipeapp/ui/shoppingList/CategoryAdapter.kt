package com.example.scrapkitchen.ui.shoppingList

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeapp.R
import com.example.recipeapp.Util
import com.example.recipeapp.db.entities.ShoppingItemEnt
import com.example.recipeapp.ui.shoppingList.ShoppingListItemAdapter
import com.example.recipeapp.ui.shoppingList.ShoppingListViewModel
import com.example.recipeapp.ui.shoppingList.SwipeGesture


class CategoryAdapter(private var itemsIn : List<ShoppingItemEnt>, private val vm: ShoppingListViewModel) : RecyclerView.Adapter<CategoryAdapter.MyViewHolder>() {
    private val items = Util.mapByProp(itemsIn)
    inner class MyViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){

        fun bind(result: List<ShoppingItemEnt>){
            itemView.findViewById<TextView>(R.id.category).text = Util.titleCase(result[0].cat)
            val childAdapter = ShoppingListItemAdapter(result,vm)
            val swipeGesture = object  : SwipeGesture(){
                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    when(direction){
                        ItemTouchHelper.LEFT -> {
                            childAdapter.deleteItem(viewHolder.adapterPosition)
                        }
                    }
                }
                //when swipe begins set colour to red
                override fun onSelectedChanged(viewHolder: RecyclerView.ViewHolder?, actionState: Int) {
                    if(actionState == ItemTouchHelper.ACTION_STATE_SWIPE){
                        viewHolder?.itemView?.setBackgroundColor(Color.parseColor("#ff5e5e"))
                    }
                }
                //on release set colour to white
                override fun clearView(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder) {
                    viewHolder.itemView.setBackgroundColor(Color.parseColor("#FFFFFF"))
                    super.clearView(recyclerView, viewHolder)
                }
            }
            val recycler = itemView.findViewById<RecyclerView>(R.id.category_recycle)
            recycler.layoutManager = LinearLayoutManager(itemView.context,LinearLayoutManager.VERTICAL,false)
            recycler.adapter = childAdapter
            val touchHelper = ItemTouchHelper(swipeGesture)
            touchHelper.attachToRecyclerView(recycler)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.shopping_list_category_rv,parent,false)
    )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        items[items.keys.elementAt(position)]?.let { holder.bind(it) }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}