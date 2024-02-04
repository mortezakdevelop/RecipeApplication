package com.example.foodorderapplication.repository

import com.example.foodorderapplication.source.RemoteDataSource
import javax.inject.Inject

class RecipeRepository @Inject constructor(remoteDataSource: RemoteDataSource) {
    val remote = remoteDataSource
}