package com.example.scrapkitchen.ui.recipe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.scrapkitchen.R
import com.example.scrapkitchen.consts.Constants
import com.example.scrapkitchen.databinding.FragmentRegionSelectBinding

class RegionSelectFragment : Fragment(), View.OnClickListener {

    private var binding: FragmentRegionSelectBinding? = null

    private val recipeViewModel: RecipeViewModel by activityViewModels { RecipeViewModel.Factory}


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentBinding = FragmentRegionSelectBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        binding!!.Africa.setOnClickListener(this)
        binding!!.Asia.setOnClickListener(this)
        binding!!.Antarctica.setOnClickListener(this)
        binding!!.NorthAmerica.setOnClickListener(this)
        binding!!.SouthAmerica.setOnClickListener(this)
        binding!!.Oceania.setOnClickListener(this)
        binding!!.Europe.setOnClickListener(this)
        binding!!.viewRecipes.setOnClickListener(this)
        recipeViewModel.selectedRecipes = -1
        return fragmentBinding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun onClick(v: View) {
        var blurb = getString(R.string.welcome_blurb)
        var title = getString(R.string.app_name)
        val consts = Constants()
        when(v.id){
            R.id.view_recipes -> {
                findNavController().navigate(R.id.action_navigation_region_select_to_recipeListFragment)
            }
            R.id.Antarctica ->{
                recipeViewModel.selectedRecipes = -1
            }
            R.id.Africa -> {
                if (recipeViewModel.selectedRecipes == consts.AFRICA){
                    recipeViewModel.selectedRecipes = -1
                    findNavController().navigate(R.id.action_navigation_region_select_to_recipeListFragment)
                }
                recipeViewModel.selectedRecipes = consts.AFRICA
                title = getString(R.string.africa_title)
                blurb = getString(R.string.africa_blurb)
            }
            R.id.Asia -> {
                if (recipeViewModel.selectedRecipes == consts.ASIA){
                    findNavController().navigate(R.id.action_navigation_region_select_to_recipeListFragment)
                }
                recipeViewModel.selectedRecipes = consts.ASIA
                title = getString(R.string.asia_title)
                blurb = getString(R.string.asia_blurb)
            }
            R.id.NorthAmerica -> {
                if (recipeViewModel.selectedRecipes == consts.NORTH_AMERICA){
                    findNavController().navigate(R.id.action_navigation_region_select_to_recipeListFragment)
                }
                recipeViewModel.selectedRecipes = consts.NORTH_AMERICA
                title = getString(R.string.north_america_title)
                blurb = getString(R.string.north_america_blurb)}
            R.id.SouthAmerica -> {
                if (recipeViewModel.selectedRecipes == consts.SOUTH_AMERICA){
                    findNavController().navigate(R.id.action_navigation_region_select_to_recipeListFragment)
                }
                recipeViewModel.selectedRecipes = consts.SOUTH_AMERICA
                title = getString(R.string.south_america_title)
                blurb = getString(R.string.south_america_blurb)
            }
            R.id.Europe -> {
                if (recipeViewModel.selectedRecipes == consts.EUROPE){
                    findNavController().navigate(R.id.action_navigation_region_select_to_recipeListFragment)
                }
                recipeViewModel.selectedRecipes = consts.EUROPE
                title = getString(R.string.europe_title)
                blurb = getString(R.string.europe_blurb)}
            R.id.Oceania -> {
                if (recipeViewModel.selectedRecipes == consts.OCEANIA){
                    findNavController().navigate(R.id.action_navigation_region_select_to_recipeListFragment)
                }
                recipeViewModel.selectedRecipes = consts.OCEANIA
                title = getString(R.string.oceania_title)
                blurb = getString(R.string.oceania_blurb)
            }
        }
        binding?.title?.text = title
        binding?.blurb?.text = blurb
    }
}