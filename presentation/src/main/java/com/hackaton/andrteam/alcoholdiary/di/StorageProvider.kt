package com.hackaton.andrteam.alcoholdiary.di

import android.content.Context
import com.hackaton.andrteam.alcoholdiary.data.storage.StorageManager

object StorageProvider {

    fun provideStorageManager(context: Context): StorageManager {
        return StorageManager(context)
    }
}