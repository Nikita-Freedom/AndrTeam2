package com.hackaton.andrteam.alcoholdiary.data.db.core

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hackaton.andrteam.alcoholdiary.data.db.dao.CalendarDailyDao
import com.hackaton.andrteam.alcoholdiary.data.db.entity.AlcoSessionDb
import com.hackaton.andrteam.alcoholdiary.data.db.entity.AlcoholDb
import com.hackaton.andrteam.alcoholdiary.data.db.entity.CalendarDailyDb
import androidx.room.Database as Db

@Db(
    entities = [CalendarDailyDb::class, AlcoSessionDb::class, AlcoholDb::class],
    version = 1
)
abstract class Database : RoomDatabase() {

    abstract fun calendarDao(): CalendarDailyDao

    companion object {
        private const val DATABASE_NAME = "AnderTeam"
        private var instance: Database? = null

        fun getDatabase(context: Context): Database {
            synchronized(Database::class) {
                return instance ?: Room
                    .databaseBuilder(
                        context.applicationContext,
                        Database::class.java,
                        DATABASE_NAME
                    )
                    .build()
                    .also {
                        instance = it
                    }
            }
        }
    }
}