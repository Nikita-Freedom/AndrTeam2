package com.hackaton.andrteam.alcoholdiary.view.report.daily

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hackaton.andrteam.alcoholdiary.domain.model.CalendarDay
import com.hackaton.andrteam.alcoholdiary.domain.usecase.GetCalendarDaysUseCase

class DailyViewModel(
    private val getCalendarDaysUseCase: GetCalendarDaysUseCase
) : ViewModel() {

    val daysLiveData: MutableLiveData<List<CalendarDay>> by lazy { MutableLiveData() }

    fun launch() {
        daysLiveData.postValue(getCalendarDaysUseCase.getAllDays())
    }

}