package com.example.foodorderapplication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.foodorderapplication.R
import com.example.foodorderapplication.databinding.FragmentRecipeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeFragment : Fragment() {

    lateinit var fragmentRecipeBinding: FragmentRecipeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentRecipeBinding = FragmentRecipeBinding.inflate(layoutInflater,container,false)
        return fragmentRecipeBinding.root
    }

}