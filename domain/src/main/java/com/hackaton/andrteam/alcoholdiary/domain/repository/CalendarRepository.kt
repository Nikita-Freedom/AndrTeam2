package com.hackaton.andrteam.alcoholdiary.domain.repository

import com.hackaton.andrteam.alcoholdiary.domain.model.CalendarDay

interface CalendarRepository {

    fun getCalendarDays(): List<CalendarDay>
}