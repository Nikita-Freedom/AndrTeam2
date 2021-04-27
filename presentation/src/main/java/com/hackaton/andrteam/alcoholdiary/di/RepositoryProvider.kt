package com.hackaton.andrteam.alcoholdiary.di

import com.hackaton.andrteam.alcoholdiary.App
import com.hackaton.andrteam.alcoholdiary.data.network.api.RetrofitApi
import com.hackaton.andrteam.alcoholdiary.data.repository.CalendarRepositoryImpl
import com.hackaton.andrteam.alcoholdiary.data.repository.UserRepositoryImpl
import com.hackaton.andrteam.alcoholdiary.domain.repository.CalendarRepository
import com.hackaton.andrteam.alcoholdiary.domain.repository.UserRepository

object RepositoryProvider {

    fun provideUserRepository(): UserRepository = UserRepositoryImpl(
        RetrofitApi.RETROFIT_SERVICE_USER,
        StorageProvider.provideStorageManager(App.instance.applicationContext)
    )

    fun provideCalendarDayRepository(): CalendarRepository = CalendarRepositoryImpl()
}