package com.hackaton.andrteam.alcoholdiary.data.storage

import android.content.Context
import android.content.SharedPreferences
import com.hackaton.andrteam.alcoholdiary.data.network.entity.User

private const val PREFERENCES_STORAGE_NAME = "PREFERENCES_STORAGE_NAME"

class StorageManager(
    context: Context,
    private val prefs: SharedPreferences =
        context.getSharedPreferences(PREFERENCES_STORAGE_NAME, Context.MODE_PRIVATE)
) {
    fun saveInfoAboutUser(user: User) {
        prefs
            .edit()
            .putString("USER_KEY", user.toString())
            .apply()
    }

    fun setIsSessionStarted(isStarted: Boolean) {
        prefs.edit().putBoolean("SESSION_STARTED", isStarted).apply()
    }

    fun isSessionStarted(): Boolean {
        return prefs.getBoolean("SESSION_STARTED", false)
    }
}