package com.hackaton.andrteam.alcoholdiary.domain.usecase

import com.hackaton.andrteam.alcoholdiary.domain.model.CalendarDay
import com.hackaton.andrteam.alcoholdiary.domain.repository.CalendarRepository

class GetCalendarDaysUseCase(
    private val calendarRepository: CalendarRepository
) {

    fun getAllDays(): List<CalendarDay> {
       return calendarRepository.getCalendarDays()
    }
}