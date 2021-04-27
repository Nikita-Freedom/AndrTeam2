package com.hackaton.andrteam.alcoholdiary.di

import com.hackaton.andrteam.alcoholdiary.di.RepositoryProvider.provideCalendarDayRepository
import com.hackaton.andrteam.alcoholdiary.domain.usecase.GetCalendarDaysUseCase
import com.hackaton.andrteam.alcoholdiary.domain.usecase.GetUserUseCase

object UseCaseProvider {

    fun provideGetUserUseCase(): GetUserUseCase =
        GetUserUseCase(RepositoryProvider.provideUserRepository())

    fun provideGetCalendarDayUseCase(): GetCalendarDaysUseCase =
        GetCalendarDaysUseCase(provideCalendarDayRepository())
}