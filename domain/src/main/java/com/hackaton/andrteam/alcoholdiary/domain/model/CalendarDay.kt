package com.hackaton.andrteam.alcoholdiary.domain.model

data class CalendarDay(
    val id: Int,
    val day: DAY,
    val number: Int,
    val dailySessions: AlcoSession? = null
)

enum class DAY(val title: String) {
    MONDAY("Пн"),
    TUESDAY("Вт"),
    WEDNESDAY("Ср"),
    THURSDAY("Чт"),
    FRIDAY("Пт"),
    SATURDAY("Сб"),
    SUNDAY("Вс")
}