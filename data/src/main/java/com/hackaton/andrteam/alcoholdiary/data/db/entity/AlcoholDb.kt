package com.hackaton.andrteam.alcoholdiary.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

internal class AlcoholDbParams {
    companion object {
        const val TABLE_NAME = "alcohol"
        const val ALCO_ID = "alco_id"
        const val SESSION_ID = "session_id"
        const val NAME = "name"
    }
}

@Entity(tableName = AlcoholDbParams.TABLE_NAME)
data class AlcoholDb(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = AlcoholDbParams.ALCO_ID)
    val id: Int? = null,
    @ColumnInfo(name = AlcoholDbParams.SESSION_ID)
    val sessionId: Int,
    @ColumnInfo(name = AlcoholDbParams.NAME)
    val name: String
)