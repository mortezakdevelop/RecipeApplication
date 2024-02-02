package com.example.foodorderapplication.source

import com.example.foodorderapplication.api.ApiService
import com.example.foodorderapplication.models.register.BodyRegisterModel
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val api: ApiService) {

    suspend fun postRegister(apiKey: String, body: BodyRegisterModel) =
        api.postRegister(apiKey, body)
}