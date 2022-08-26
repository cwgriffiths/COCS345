package com.example.recipeapp

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeapp.databinding.ShoppingListRvBinding
import com.example.recipeapp.entities.RecipeEnt
import com.example.recipeapp.entities.ShoppingItemEnt
import com.example.recipeapp.fragments.ShoppingList

class SItemAdapter(private val shoppingList: List<ShoppingItemEnt>) : RecyclerView.Adapter<SItemAdapter.MyViewHolder>() {
    class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
        val name: TextView = view.findViewById<TextView>(R.id.slist_name)
        val metric: TextView = view.findViewById<TextView>(R.id.slist_amount_metric)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = LayoutInflater.from(parent.context).inflate(R.layout.shopping_list_rv,parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return shoppingList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = shoppingList[position]
        holder.name.text = item.item
        holder.metric.text = item.amount.toString() + " "+ item.metric
    }
}