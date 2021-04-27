package com.hackaton.andrteam.alcoholdiary.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hackaton.andrteam.alcoholdiary.data.db.entity.AlcoSessionDb
import com.hackaton.andrteam.alcoholdiary.data.db.entity.AlcoSessionParams

@Dao
interface AlcoSessionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(alcoSessionDb: AlcoSessionDb)

    @Query("SELECT * FROM ${AlcoSessionParams.TABLE_NAME} WHERE ${AlcoSessionParams.DAY_ID}=(:dayId)")
    fun findSessionByDayId(dayId: Int): AlcoSessionDb
}