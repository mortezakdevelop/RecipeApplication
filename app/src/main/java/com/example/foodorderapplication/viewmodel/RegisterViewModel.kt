package com.example.foodorderapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodorderapplication.models.register.BodyRegisterModel
import com.example.foodorderapplication.models.register.ResponseRegisterModel
import com.example.foodorderapplication.repository.RegisterRepository
import com.example.foodorderapplication.utils.NetworkRequest
import com.example.foodorderapplication.utils.NetworkResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val repository: RegisterRepository
):ViewModel() {

    //Api
    val registerData = MutableLiveData<NetworkRequest<ResponseRegisterModel>>()
    fun callRegisterApi(apiKey: String, body: BodyRegisterModel) = viewModelScope.launch {
        registerData.value = NetworkRequest.Loading()
        val response = repository.postRegister(apiKey, body)
        registerData.value = NetworkResponse(response).generalNetworkResponse()
    }


    //Stored data
    fun saveData(username: String, hash: String) = viewModelScope.launch {
        repository.saveRegisterData(username, hash)
    }

    val readData = repository.readRegisterData
}