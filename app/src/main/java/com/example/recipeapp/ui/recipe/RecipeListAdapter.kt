package com.example.recipeapp.ui.recipe

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeapp.consts.Emojis
import com.example.recipeapp.databinding.RecipeRowBinding
import com.example.recipeapp.db.entities.RecipeEnt


class RecipeListAdapter(
    private val recipeList: List<RecipeEnt>,
    private val vm: RecipeViewModel,
    private val listener: RecipeListFragment
) : RecyclerView.Adapter<RecipeListAdapter.MyViewHolder>() {
    private val emojis = Emojis.Companion

    inner class MyViewHolder(
        recipeRowBinding: RecipeRowBinding,
        private val onRecipeSelected: OnRecipeSelected
    ) : RecyclerView.ViewHolder(recipeRowBinding.root), View.OnClickListener {
        init {
            recipeRowBinding.root.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            vm.setCurRecipe(recipeList[adapterPosition])
            onRecipeSelected.onRecipeSelected(recipeList[adapterPosition])
        }

        var title = recipeRowBinding.titleTxt
        var emoji = recipeRowBinding.idTxt

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = RecipeRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = recipeList[position]
        val titleEdit = "\n${currentItem.name}\n".replace("(", "\n(")
        holder.title.text = titleEdit
        holder.emoji.text = emojis.getEmoji(currentItem.country)
    }

    override fun getItemCount(): Int {
        return recipeList.size
    }

    interface OnRecipeSelected {
        fun onRecipeSelected(recipe: RecipeEnt)
    }
}