package com.example.foodorderapplication.models.register

import com.google.gson.annotations.SerializedName

data class ResponseRegisterModel(
    @SerializedName("hash")
    val hash: String?, // q572587bq2405724q05
    @SerializedName("spoonacularPassword")
    val spoonacularPassword: String?, // meadwith31grapejam
    @SerializedName("username")
    val username: String? // api_123_user
)