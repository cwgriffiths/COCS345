package com.example.recipeapp.entities

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Parcelable data class to store a recipe
 * Acts as a row in the recipe table in the database
 */
@Entity(tableName = "recipe_table")
data class RecipeEnt(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "title") val name: String,
    @ColumnInfo(name = "description") val description: String,
    // 1= north america, 2 = south america, 3 = africa , 4 = europe, 5= Asia, 6 = oceanania, 7 = antarictica
    @ColumnInfo(name = "region") val region: Int,
    @ColumnInfo(name = "ingredients") val ingredients: String,
    @ColumnInfo(name = "method") val method: String,
    @ColumnInfo(name = "servings") val servings: Int,
    @ColumnInfo(name = "country") val country: String,
    @ColumnInfo(name = "recipeShopping") val recipeShopping: String,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        id = parcel.readInt(),
        name = parcel.readString() ?: "",
        description = parcel.readString() ?: "",
        region = parcel.readInt(),
        ingredients = parcel.readString() ?: "",
        method = parcel.readString() ?: "",
        servings = parcel.readInt(),
        country = parcel.readString() ?: "",
        recipeShopping = parcel.readString() ?: ""
    )

    /**
     * This is used to save the data to the parcel
     */
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeInt(region)
        parcel.writeString(ingredients)
        parcel.writeString(method)
        parcel.writeInt(servings)
        parcel.writeString(country)
        parcel.writeString(recipeShopping)
    }

    /**
     * This is used to describe the content of the parcel
     */
    override fun describeContents(): Int {
        return 0
    }

    /**
     * This companion object creates an instance of the RecipeEnt class from a parcel
     */
    companion object CREATOR : Parcelable.Creator<RecipeEnt> {
        /**
         * Create a new instance from the parcel
         */
        override fun createFromParcel(parcel: Parcel): RecipeEnt {
            return RecipeEnt(parcel)
        }

        /**
         * Create a new array nulls of the specified size
         */
        override fun newArray(size: Int): Array<RecipeEnt?> {
            return arrayOfNulls(size)
        }
    }
}