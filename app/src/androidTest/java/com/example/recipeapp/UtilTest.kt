package com.example.recipeapp

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.recipeapp.db.entities.ShoppingItemEnt
import junit.framework.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UtilTest {


    @Test
    fun titleCase(){
        val title = "Hello There Title Test"
        val nonTitle = "hello there title test"
        assertEquals(title, Util.titleCase(nonTitle))
        val title2 = "Hello There Title Test2 "
        val nonTitle2 = "HeLLo ThErE tiTlE teSt2 "
        assertEquals(title2, Util.titleCase(nonTitle2))
        val title3 = " "
        val nonTitle3 = " "
        assertEquals(title3, Util.titleCase(nonTitle3))

        assertEquals("Hello World", Util.titleCase("hello world"))
        assertEquals("Hello World", Util.titleCase("HELLO WORLD"))
        assertEquals("Hello World", Util.titleCase("hELLO wORLD"))
        assertEquals("Hello World", Util.titleCase("Hello World"))
        assertEquals("Hello World", Util.titleCase("hello WORLD"))
        assertEquals("Hello World", Util.titleCase("Hello world"))
        assertEquals("Hello World", Util.titleCase("hello World"))
    }
    @Test
    fun mapByProp(){
        val itemList: List<ShoppingItemEnt> = listOf( ShoppingItemEnt(0,"Apples",2.1,"kg",false,"Fruit"),ShoppingItemEnt(1,"Carrots",5.4,"kg",false,"Vege"),ShoppingItemEnt(2,"Pineapple",2.6,"kg",false,"Fruit"),ShoppingItemEnt(3,"Beef",2.1,"kg",false,"Meat"),ShoppingItemEnt(4,"Cheese",2.1,"kg",false,"Dairy"))
        val fruits: List<ShoppingItemEnt> = listOf(ShoppingItemEnt(0,"Apples",2.1,"kg",false,"Fruit"),ShoppingItemEnt(2,"Pineapple",2.6,"kg",false,"Fruit"))
        val meats: List<ShoppingItemEnt> = listOf(ShoppingItemEnt(3,"Beef",2.1,"kg",false,"Meat"))
        val map = Util.mapByProp(itemList)
        assertEquals(map["fruit"],fruits)
        assertEquals(map["meat"]!!.size,meats.size)
    }

    @Test
    fun stringToFormattedList(){
        val test =
            Util.stringToFormattedList("1/4kg [whole chicken], cut into pieces or chicken wings\\ 2Tbsp [rice wine]\\ 2tsp minced [ginger]\\ 1tsp fine sea [salt]")
        val expected = "1/4kg whole chicken, cut into pieces or chicken wings\n\n2Tbsp rice wine\n\n2tsp minced ginger\n\n1tsp fine sea salt\n\n"
        assertEquals(test.toString(),expected)
    }

    @Test
    fun ingredientsToList(){
        val ing = "1, Whole, pantry, Pie"
        val expectedItem = ShoppingItemEnt(0,"Pie",1.0,"Whole",true,"pantry")
        val list = Util.ingredientsToList(ing)
        println(list)
        assert(list.contains(expectedItem))
    }
}