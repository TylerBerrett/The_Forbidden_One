package com.tylerb.testapp.util

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton


private val Context.defaultDataStore: DataStore<Preferences> by preferencesDataStore(name = DataStoreManager.DEFAULT_PREF)

@Singleton
class DataStoreManager @Inject constructor(@ApplicationContext appContext: Context) {

    private val defaultDataStore = appContext.defaultDataStore

    suspend fun setDefaultString(string: String) {
        defaultDataStore.edit { pref ->
            pref[STRING_KEY] = string
        }
    }

    val getString: Flow<String> = defaultDataStore.data.map { pref ->
        pref[STRING_KEY] ?: ""
    }


    companion object {
        const val DEFAULT_PREF = "default_pref"
        private val STRING_KEY = stringPreferencesKey("key")
    }

}
