package com.example.recipeapp.entities

import android.os.Parcel
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

/**
 * @author Conor Griffiths
 */
@RunWith(MockitoJUnitRunner::class)
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

    /**
     * Test the parcelable implementation
     */
    @Test
    fun parcelableTest2(){
        assert(recipe.describeContents() == 0)

        val testArray = RecipeEnt.CREATOR.newArray(1)
        assert(testArray[0] == null)
        assert(testArray.size == 1)
    }

    /**
     * Test the constructor works correctly
     */
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