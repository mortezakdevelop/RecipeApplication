package com.example.foodorderapplication.viewmodel

import androidx.lifecycle.ViewModel
import com.example.foodorderapplication.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel @Inject constructor(
    private val recipeRepository: RecipeRepository
):ViewModel() {
    
}