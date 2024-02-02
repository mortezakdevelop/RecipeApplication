package com.example.foodorderapplication.di.module

import com.example.foodorderapplication.models.register.BodyRegisterModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(FragmentComponent::class)
object FoodOrderModule {

    @Provides
    fun bodyRegister() = BodyRegisterModel()
}