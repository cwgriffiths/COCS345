package com.example.recipeapp

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
//        println(items.keys.elementAt(position))
        items[items.keys.elementAt(position)]?.let { holder.bind(it) }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}