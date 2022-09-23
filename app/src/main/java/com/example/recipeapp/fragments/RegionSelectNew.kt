package com.example.recipeapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.example.recipeapp.R
import com.example.recipeapp.activities.MainActivity
import com.example.recipeapp.dao.Maps
import com.example.recipeapp.databinding.FragmentRegionSelectNewBinding

/**
 * Continent select fragment
 * @author Conor Griffiths
 */
class RegionSelectNew(private val supportFragmentManager: FragmentManager) : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentRegionSelectNewBinding

    private var selectedRecipes = -1

    /**
     * This method is called when the fragment is created
     * @param inflater inflater to be called on the layout
     * @param container the container to be inflated
     * @param savedInstanceState if there is a previous version of this fragment use that
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        MainActivity.setContinentID(-1)
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

    /**
     * This function changes the view to the recipes from the selected region
     */
    private fun viewRecipes() {
        MainActivity.setContinentID(selectedRecipes)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, Recipe(selectedRecipes))
            .commit()
    }

    /**
     * Click handler for hidden continent buttons and view recipes button
     * If a continent is tapped show info about food from that continent, if continent already
     * selected show recipes from that continent
     * If view recipes is tapped show the recipes from the selected continent
     * @param p0 the view that was clicked
     */
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

    /**
     * toString is used to set the view title
     */
    override fun toString(): String {
        return "Select a Continent"
    }
}