package com.hackaton.andrteam.alcoholdiary.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hackaton.andrteam.alcoholdiary.data.db.entity.AlcoholDb
import com.hackaton.andrteam.alcoholdiary.data.db.entity.AlcoholDbParams

@Dao
interface AlcoholDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(alcoholList: List<AlcoholDb>)

    @Query("SELECT * FROM ${AlcoholDbParams.TABLE_NAME} WHERE ${AlcoholDbParams.SESSION_ID}=(:sessionId)")
    fun findAlcoholBySessionId(sessionId: Int): List<AlcoholDb>
}