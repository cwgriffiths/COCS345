package com.example.recipeapp.ui.shoppingList

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

/**
 * Adapter for the shopping list, used as the outer adapter with a nested inner adapter
 */
class CategoryAdapter(private val items : Map<String,List<ShoppingItemEnt>>, private val listener: ShoppingList) : RecyclerView.Adapter<CategoryAdapter.MyViewHolder>() {

    /**
     * Inner adapter for the shopping list
     */
    inner class MyViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){

        /**
         * Binds the inner adapter to the recycler view
         */
        fun bind(result: List<ShoppingItemEnt>){
            itemView.findViewById<TextView>(R.id.category).text = Util.titleCase(result[0].cat)
            val childAdapter = SItemAdapter(result,listener)
            val swipeGesture = object  : SwipeGesture(){

                /**
                 * Called when a ViewHolder is swiped by the user.
                 */
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