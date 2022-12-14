package com.testtask.myapplication.data.local

import android.content.SharedPreferences
import com.google.gson.Gson
import com.testtask.myapplication.core.type.None
import com.testtask.myapplication.domain.model.User
class LocalCacheImpl(
    private val prefsManager: SharedPreferences
): LocalCache {

    override fun saveUser(user: User): None {
        prefsManager.edit().apply {
            putString(USER_PROFILE, Gson().toJson(user))
        }.apply()

        return None()
    }

    override fun getUser(): User? {
        val json = prefsManager.getString(USER_PROFILE, null)
        return Gson().fromJson(json, User::class.java)
    }


    companion object {
        private const val USER_PROFILE = "user_profile"
    }
}

