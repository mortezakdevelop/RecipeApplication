package com.example.foodorderapplication.api

import com.example.foodorderapplication.models.recipe.ResponseRecipes
import com.example.foodorderapplication.models.register.BodyRegisterModel
import com.example.foodorderapplication.models.register.ResponseRegisterModel
import com.example.foodorderapplication.utils.Contracts.API_KEY
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface ApiService {
    @POST("users/connect")
    suspend fun postRegister(@Query(API_KEY) apiKey: String, @Body body: BodyRegisterModel): Response<ResponseRegisterModel>

    @GET("recipes/complexSearch")
    suspend fun getRecipes(@QueryMap queries: Map<String, String>): Response<ResponseRecipes>


}