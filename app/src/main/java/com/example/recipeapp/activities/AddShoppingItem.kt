package com.example.recipeapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.recipeapp.AppDB
import com.example.recipeapp.R
import com.example.recipeapp.entities.ShoppingItemEnt

class AddShoppingItem : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_shopping_item)
    }

    fun addItem(view: View){
        var name = findViewById<EditText>(R.id.name).text.toString()
        var cate = findViewById<EditText>(R.id.category).text.toString()
        var metric = findViewById<EditText>(R.id.metric).text.toString()
        var amount = findViewById<EditText>(R.id.amount).text.toString()
        var ent: ShoppingItemEnt = ShoppingItemEnt(0,name,amount.toInt(),metric,false,cate)
        AppDB.getInstance(applicationContext).shoppingItemDAO().addItem(ent)
        println(AppDB.getInstance(applicationContext).shoppingItemDAO().getShoppingList())
        finish()

    }
}