package com.example.myfirstapp

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map
import java.util.concurrent.Flow


class UserManager(context: Context) {
    // создайте хранилище данных и дайте ему имя, такое же, как общие настройки
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user")
    private val mDataStore: DataStore<Preferences> = context.dataStore


    // создать несколько ключей, которые мы будем использовать для хранения и извлечения данных
    companion object {
        val USER_LOGIN_KEY = stringPreferencesKey("USER_LOGIN")
        val USER_PASSWORD_KEY = stringPreferencesKey("USER_PASSWORD")
    }


    /**
     * Хранить пользовательские данные
     * обратитесь к хранилищу данных и с помощью редактирования
     * мы можем хранить значения с помощью ключей
     */

    suspend fun storeUserData(login: String, password: String) {
        mDataStore.edit { preferences ->
            preferences[USER_LOGIN_KEY] = login
            preferences[USER_PASSWORD_KEY] = password
            // это настройки, которые мы редактируем
        }
    }

    // Создаем поток возраста для получения возраста из предпочтений
    // Flow является частью корутины kotlin


    val userLoginFlow = mDataStore.data.map {
        it[USER_LOGIN_KEY] ?: ""

        // пустая строка - значение по умолчанию,  требуется по умолчанию
    }

    val userPasswordFlow = mDataStore.data.map {
        it[USER_PASSWORD_KEY] ?: ""

        // пустая строка - значение по умолчанию,  требуется по умолчанию
    }


}