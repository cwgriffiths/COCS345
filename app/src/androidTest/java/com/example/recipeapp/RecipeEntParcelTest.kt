package com.example.recipeapp

import android.os.Parcel
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.recipeapp.entities.RecipeEnt
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author Conor Griffiths
 */
@RunWith(AndroidJUnit4::class)
class RecipeEntParcelTest {

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

    /**
     * Test that the parcelable implementation is working correctly
     */
    @Test
    fun parcelableTest(){
        val parcel = Parcel.obtain()
        recipe.writeToParcel(parcel, recipe.describeContents())
        parcel.setDataPosition(0)
        val createdFromParcel = RecipeEnt.CREATOR.createFromParcel(parcel)
        assert(createdFromParcel == recipe)
    }

    /**
     * Test that the parcelable implementation is working correctly
     */
    @Test
    fun parcelableTest3(){
        val parcel = Parcel.obtain()
        recipe.writeToParcel(parcel, recipe.describeContents())
        parcel.setDataPosition(0)
        val createdFromParcel = RecipeEnt(parcel)
        assert(createdFromParcel == recipe)
    }

}