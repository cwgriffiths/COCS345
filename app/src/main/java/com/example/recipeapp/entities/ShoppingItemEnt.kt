package com.example.recipeapp.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "item_table")
data class ShoppingItemEnt(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "item") val item: String,
    @ColumnInfo(name = "amount") val amount: Int,
    @ColumnInfo(name = "metric") val metric: String,
    @ColumnInfo(name = "checked") val checked: Boolean,
    @ColumnInfo(name = "category") val cat: String
)
