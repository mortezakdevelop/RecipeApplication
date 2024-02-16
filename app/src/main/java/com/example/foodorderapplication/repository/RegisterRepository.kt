package com.example.foodorderapplication.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.foodorderapplication.models.register.BodyRegisterModel
import com.example.foodorderapplication.models.register.RegisterStoredModel
import com.example.foodorderapplication.source.RemoteDataSource
import com.example.foodorderapplication.utils.Contracts
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject

@ActivityRetainedScoped
class RegisterRepository @Inject constructor(
    private val context: Context,
    private val remote:RemoteDataSource
) {

    //Store user info
    private object StoredKeys {
        val username = stringPreferencesKey(Contracts.REGISTER_USERNAME)
        val hash = stringPreferencesKey(Contracts.REGISTER_HASH)
    }

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(Contracts.REGISTER_USER_INFO)

    suspend fun saveRegisterData(username: String, hash: String) {
        context.dataStore.edit {
            it[StoredKeys.username] = username
            it[StoredKeys.hash] = hash
        }
    }

    val readRegisterData: Flow<RegisterStoredModel> = context.dataStore.data
        .catch { e ->
            if (e is IOException) {
                emit(emptyPreferences())
            } else {
                throw e
            }
        }.map {
            val username = it[StoredKeys.username] ?: ""
            val hash = it[StoredKeys.hash] ?: ""
            RegisterStoredModel(username, hash)
        }

    //API
    suspend fun postRegister(apiKey: String, body: BodyRegisterModel) = remote.postRegister(apiKey, body)
}