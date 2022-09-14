package com.example.recipeapp

import android.os.Parcel
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.recipeapp.entities.RecipeEnt
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RecipeEntTest {

    private val recipe = RecipeEnt(
        id = 1,
        name = "an apple",
        description = "a red fruit",
        region = 1,
        ingredients = "apple",
        method = "eat it",
        servings = 1,
        country = "America",
        recipeShopping = "apple"
    )

    @Test
    fun parcelableTest(){
        val parcel = Parcel.obtain()
        recipe.writeToParcel(parcel, recipe.describeContents())
        parcel.setDataPosition(0)
        val createdFromParcel = RecipeEnt.CREATOR.createFromParcel(parcel)
        assert(createdFromParcel == recipe)
    }

    @Test
    fun parcelableTest2(){
        assert(recipe.describeContents() == 0)

        val testArray = RecipeEnt.CREATOR.newArray(1)
        assert(testArray[0] == null)
        assert(testArray.size == 1)
    }

    @Test
    fun parcelableTest3(){
        val parcel = Parcel.obtain()
        recipe.writeToParcel(parcel, recipe.describeContents())
        parcel.setDataPosition(0)
        val createdFromParcel = RecipeEnt(parcel)
        assert(createdFromParcel == recipe)
    }

    @Test
    fun constructorTest(){
        val recipe2 = RecipeEnt(
            id = 1,
            name = "an apple",
            description = "a red fruit",
            region = 1,
            ingredients = "apple",
            method = "eat it",
            servings = 1,
            country = "America",
            recipeShopping = "apple"
        )
        assert(recipe == recipe2)
    }



}