package com.hackaton.andrteam.alcoholdiary.data.db.entity

import androidx.room.*

internal class CalendarDayilyParams {
    companion object {
        const val TABLE_NAME = "calendarDay"
        const val ID = "id"
        const val NAME = "name"
        const val NUMBER = "number"
        const val SESSION = "session_"
    }
}

@Entity(tableName = CalendarDayilyParams.TABLE_NAME)
data class CalendarDailyDb(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = CalendarDayilyParams.ID)
    val id: Int,
    @ColumnInfo(name = CalendarDayilyParams.NAME)
    val name: String,
    @ColumnInfo(name = CalendarDayilyParams.NUMBER)
    val number: Int
)