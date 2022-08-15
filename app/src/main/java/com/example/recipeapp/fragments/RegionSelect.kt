package com.example.recipeapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.example.recipeapp.R
import com.example.recipeapp.dao.Maps
import com.example.recipeapp.databinding.FragmentRegionSelectBinding

class RegionSelect(private val supportFragmentManager: FragmentManager) : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentRegionSelectBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegionSelectBinding.inflate(layoutInflater)

        binding.NorthAmerica.setOnClickListener(this)
        binding.SouthAmerica.setOnClickListener(this)
        binding.Europe.setOnClickListener(this)
        binding.Asia.setOnClickListener(this)
        binding.Africa.setOnClickListener(this)
        binding.Oceania.setOnClickListener(this)
        binding.All.setOnClickListener(this)


        return binding.root
    }

    override fun onClick(p0: View?) {
        val maps = Maps()
        val regionId = when(p0?.id){
                R.id.NorthAmerica -> {
                    maps.NORTH_AMERICA
                }
                R.id.SouthAmerica -> {
                    maps.SOUTH_AMERICA
                }
                R.id.Europe -> {
                    maps.EUROPE
                }
                R.id.Asia -> {
                    maps.ASIA
                }
                R.id.Africa -> {
                    maps.AFRICA
                }
                R.id.Oceania -> {
                    maps.OCEANIA
                }
            else -> {
                -1
            }
        }
        val fragment = Recipe(regionId)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }

}