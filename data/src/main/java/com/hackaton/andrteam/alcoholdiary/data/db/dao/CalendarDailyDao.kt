package com.hackaton.andrteam.alcoholdiary.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hackaton.andrteam.alcoholdiary.data.db.entity.CalendarDailyDb
import com.hackaton.andrteam.alcoholdiary.data.db.entity.CalendarDayilyParams

@Dao
interface CalendarDailyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(days: List<CalendarDailyDb>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(day: CalendarDailyDb)

    @Query("SELECT * FROM ${CalendarDayilyParams.TABLE_NAME}")
    fun getAllDays(): List<CalendarDailyDb>

    @Query("DELETE FROM ${CalendarDayilyParams.TABLE_NAME}")
    fun removeAll()
}