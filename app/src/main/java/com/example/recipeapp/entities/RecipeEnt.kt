package com.example.recipeapp.entities

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipe_table")
data class RecipeEnt(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "title") val name: String,
    @ColumnInfo(name = "description") val description: String,
    //Regions 1-7 represent the 7 continents
    // 1= north america, 2 = south america, 3 = africa , 4 = europe, 5= Asia, 6 = oceanania, 7 = antarictica
    @ColumnInfo(name = "region") val region: Int,
    @ColumnInfo(name = "ingredients") val ingredients: String,
    @ColumnInfo(name = "method") val method: String,
    @ColumnInfo(name = "servings") val servings: Int,
    @ColumnInfo(name = "country") val country: String,
    @ColumnInfo(name = "recipeShopping") val recipeShopping: String,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeInt(region)
        parcel.writeString(ingredients)
        parcel.writeString(method)
        parcel.writeInt(servings)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RecipeEnt> {
        override fun createFromParcel(parcel: Parcel): RecipeEnt {
            return RecipeEnt(parcel)
        }

        override fun newArray(size: Int): Array<RecipeEnt?> {
            return arrayOfNulls(size)
        }
    }
}