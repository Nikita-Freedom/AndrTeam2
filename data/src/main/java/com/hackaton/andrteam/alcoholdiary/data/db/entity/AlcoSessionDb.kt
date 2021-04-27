package com.hackaton.andrteam.alcoholdiary.data.db.entity

import androidx.room.*
import java.util.*

internal class AlcoSessionParams {
    companion object {
        const val TABLE_NAME = "alcosession"
        const val ALCO_SESS_ID = "sess_id"
        const val DAY_ID = "day_id"
        const val START = "start"
        const val END = "end"
        const val ITEMS = "items_"
    }
}

@Entity(tableName = AlcoSessionParams.TABLE_NAME)
class AlcoSessionDb(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = AlcoSessionParams.ALCO_SESS_ID)
    val id: Int,
    @ColumnInfo(name = AlcoSessionParams.DAY_ID)
    val dayId: Int,
    @ColumnInfo(name = AlcoSessionParams.START)
    val startTime: String,
    @ColumnInfo(name = AlcoSessionParams.END)
    val endTime: String
)