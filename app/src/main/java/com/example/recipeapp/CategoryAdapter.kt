package com.example.recipeapp

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeapp.entities.ShoppingItemEnt
import com.example.recipeapp.fragments.ShoppingList

/**
 * Adapter for the shopping list, used as the outer adapter with a nested inner adapter
 */
class CategoryAdapter(private val items : Map<String,List<ShoppingItemEnt>>,private val listener: ShoppingList) : RecyclerView.Adapter<CategoryAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){

        fun bind(result: List<ShoppingItemEnt>){
            itemView.findViewById<TextView>(R.id.category).text = Util.titleCase(result[0].cat)
            val childAdapter = SItemAdapter(result,listener)
            val swipeGesture = object  : SwipeGesture(){
                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    when(direction){
                        ItemTouchHelper.LEFT -> {
                            childAdapter.deleteItem(viewHolder.adapterPosition)
                        }
                    }
                }

                /**
                 * When swipe begins set the background color of the view to red
                 */
                override fun onSelectedChanged(viewHolder: RecyclerView.ViewHolder?, actionState: Int) {
                    if(actionState == ItemTouchHelper.ACTION_STATE_SWIPE){
                        viewHolder?.itemView?.setBackgroundColor(Color.parseColor("#ff5e5e"))
                    }
                }

                /**
                 * On release of the swipe set the background color to white
                 */
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

    /**
     * Create the view holder
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.shopping_list_category_rv,parent,false)
    )

    /**
     * Bind the view holder
     */
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        items[items.keys.elementAt(position)]?.let { holder.bind(it) }
    }

    /**
     * Get the number of items in the list
     */
    override fun getItemCount(): Int {
        return items.size
    }
}