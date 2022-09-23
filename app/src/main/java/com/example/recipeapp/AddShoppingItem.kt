package com.example.recipeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Spinner
import com.example.recipeapp.db.AppDB
import com.example.recipeapp.db.entities.ShoppingItemEnt

/**
 * Activity for adding a new shopping item
 */
class AddShoppingItem : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_shopping_item)
    }

    /**
     * Function is triggered when the save button is clicked.
     */
    fun addItem(view: View) {
        val name = findViewById<EditText>(R.id.name).text.toString()
        val cate = findViewById<Spinner>(R.id.category).selectedItem.toString()
        val metric = findViewById<Spinner>(R.id.metric).selectedItem.toString()
        val amount = findViewById<EditText>(R.id.amount).text.toString()
        val ent = ShoppingItemEnt(0,name,amount.toDoubleOrNull() ?: 0.0,metric,false,cate)
        AppDB.getInstance(applicationContext).shoppingItemDAO().addItem(ent)
        finish()
    }
}