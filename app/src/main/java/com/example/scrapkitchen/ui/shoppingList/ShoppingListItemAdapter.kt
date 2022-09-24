package com.example.scrapkitchen.ui.shoppingList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.scrapkitchen.R
import com.example.scrapkitchen.db.entities.ShoppingItemEnt
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.math.floor

class ShoppingListItemAdapter(private val shoppingList: List<ShoppingItemEnt>, private val vm:ShoppingListViewModel) : RecyclerView.Adapter<ShoppingListItemAdapter.MyViewHolder>() {
    inner class MyViewHolder(view: View): RecyclerView.ViewHolder(view),View.OnClickListener{
        init {
            view.findViewById<CheckBox>(R.id.s_got).setOnClickListener(this)
            println(shoppingList)
        }
        val name: TextView = view.findViewById<TextView>(R.id.slist_name)
        val metric: TextView = view.findViewById<TextView>(R.id.slist_amount_metric)
        val checkbox : CheckBox = view.findViewById<CheckBox>(R.id.s_got)
        override fun onClick(view: View){
            GlobalScope.launch {
                val item = shoppingList[adapterPosition]
                vm.checkItem(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = LayoutInflater.from(parent.context).inflate(R.layout.shopping_list_rv,parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return shoppingList.size
    }

    fun getItems() : List<ShoppingItemEnt>{
        return shoppingList
    }

    fun deleteItem(i : Int){
        vm.removeItem(shoppingList[i])
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = shoppingList[position]
        holder.name.text = item.item
        holder.checkbox.setChecked(item.checked)
        var amount = item.amount.toString()
        if (item.amount.toDouble() == floor(item.amount.toDouble())){
            amount = item.amount.toInt().toString()
        }
        holder.metric.text = amount + " "+ item.metric


    }
}