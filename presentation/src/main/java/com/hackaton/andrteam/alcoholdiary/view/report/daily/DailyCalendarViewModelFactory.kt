package com.hackaton.andrteam.alcoholdiary.view.report.daily

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hackaton.andrteam.alcoholdiary.di.UseCaseProvider
import com.hackaton.andrteam.alcoholdiary.domain.usecase.GetCalendarDaysUseCase

class DailyCalendarViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DailyViewModel::class.java)) {
            return DailyViewModel(UseCaseProvider.provideGetCalendarDayUseCase()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}