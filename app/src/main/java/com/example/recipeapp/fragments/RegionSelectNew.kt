package com.example.recipeapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.example.recipeapp.R
import com.example.recipeapp.dao.Maps
import com.example.recipeapp.databinding.FragmentRegionSelectNewBinding

class RegionSelectNew(private val supportFragmentManager: FragmentManager) : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentRegionSelectNewBinding

    private var selectedRecipes = -1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegionSelectNewBinding.inflate(layoutInflater)

        binding.NorthAmerica.setOnClickListener(this)
        binding.SouthAmerica.setOnClickListener(this)
        binding.Europe.setOnClickListener(this)
        binding.Asia.setOnClickListener(this)
        binding.Africa.setOnClickListener(this)
        binding.Oceania.setOnClickListener(this)
        binding.Antarctica.setOnClickListener(this)
        binding.viewRecipes.setOnClickListener(this)

        return binding.root
    }

    private fun viewRecipes() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, Recipe(selectedRecipes))
            .commit()
    }

    override fun onClick(p0: View?) {
        if(p0?.id==R.id.view_recipes){
            viewRecipes()
            return
        }
        val blurb : String
        val title : String
        val maps = Maps()
        selectedRecipes = when(p0?.id){
            R.id.NorthAmerica -> {
                title = getString(R.string.north_america_title)
                blurb = getString(R.string.north_america_blurb)
                if(selectedRecipes == maps.NORTH_AMERICA){
                    viewRecipes()
                    return
                }
                maps.NORTH_AMERICA
            }
            R.id.SouthAmerica -> {
                title = getString(R.string.south_america_title)
                blurb = getString(R.string.south_america_blurb)
                if(selectedRecipes == maps.SOUTH_AMERICA){
                    viewRecipes()
                    return
                }
                maps.SOUTH_AMERICA
            }
            R.id.Europe -> {
                title = getString(R.string.europe_title)
                blurb = getString(R.string.europe_blurb)
                if (selectedRecipes == maps.EUROPE) {
                    viewRecipes()
                    return
                }
                maps.EUROPE
            }
            R.id.Asia -> {
                title = getString(R.string.asia_title)
                blurb = getString(R.string.asia_blurb)
                if (selectedRecipes == maps.ASIA) {
                    viewRecipes()
                    return
                }
                maps.ASIA
            }
            R.id.Africa -> {
                title = getString(R.string.africa_title)
                blurb = getString(R.string.africa_blurb)
                if (selectedRecipes == maps.AFRICA) {
                    viewRecipes()
                    return
                }
                maps.AFRICA
            }
            R.id.Oceania -> {
                title = getString(R.string.oceania_title)
                blurb = getString(R.string.oceania_blurb)
                if (selectedRecipes == maps.OCEANIA) {
                    viewRecipes()
                    return
                }
                maps.OCEANIA
            }
            else -> {
                title = getString(R.string.welcome_title)
                blurb = getString(R.string.welcome_blurb)
                if(selectedRecipes == -1){
                    viewRecipes()
                    return
                }
                -1
            }
        }
        binding.title.text = title
        binding.blurb.text = blurb
    }

    override fun toString(): String {
        return "Select a Region"
    }

}