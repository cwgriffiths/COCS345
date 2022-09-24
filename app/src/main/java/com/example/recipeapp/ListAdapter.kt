package com.example.recipeapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeapp.consts.Emojis
import com.example.recipeapp.databinding.RecipeRowBinding
import com.example.recipeapp.db.entities.RecipeEnt
import com.example.recipeapp.ui.recipe.Recipe

/**
 * Adapter class for the list of available recipes
 */
class ListAdapter(private val listener: Recipe): RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var recipeList = emptyList<RecipeEnt>()
    private val emojis = Emojis.Companion
    //private var listener: OnItemClickListener;

    /**
     * Inner class for the view holder
     */
    inner class MyViewHolder(val binding: RecipeRowBinding, private val onClickListener: OnItemClickListener): RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        init {
            binding.root.setOnClickListener(this)
        }

        /**
         * This method is called when the item is clicked
         */
        override fun onClick(v: View?) {
            val recipe = recipeList[adapterPosition]
            onClickListener.onItemClick(recipe)
        }
    }

    /**
     * Interface for the click listener
     */
    interface OnItemClickListener {
        /**
         * This method is called when the item is clicked
         */
        fun onItemClick(recipe: RecipeEnt)
    }


    /**
     * Creates and returns a new ViewHolder object with a reference to the view binding
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = RecipeRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding, listener)
    }

    /**
     * Returns the size of the list
     */
    override fun getItemCount(): Int {
        return recipeList.size
    }

    /**
     * Called by RecyclerView to display the data at the specified position.
     */
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = recipeList[position]
        //Sets the text fields of the recipe list item
        val title = "\n${currentItem.name}\n".replace("(","\n(")
        holder.binding.titleTxt.text = title
        holder.binding.idTxt.text = emojis.getEmoji(currentItem.country)
    }

    /**
     * Sets the list of recipes to be displayed
     */
    fun setRecipeList(recipeList: List<RecipeEnt>) {
        this.recipeList = recipeList
    }

}