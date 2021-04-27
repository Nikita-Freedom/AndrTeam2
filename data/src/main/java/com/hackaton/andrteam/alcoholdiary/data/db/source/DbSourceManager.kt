package com.hackaton.andrteam.alcoholdiary.data.db.source

import com.hackaton.andrteam.alcoholdiary.data.db.dao.AlcoSessionDao
import com.hackaton.andrteam.alcoholdiary.data.db.dao.AlcoholDao
import com.hackaton.andrteam.alcoholdiary.data.db.dao.CalendarDailyDao
import com.hackaton.andrteam.alcoholdiary.domain.model.CalendarDay

class DbSourceManager(

) {

//    fun insertDay(calendarDay: CalendarDay) {
//
//        calendarDay.dailySessions?.let {
//            alcoSessionDao.insert(
//                AlcoSessionDb(
//                    id = it.id,
//                    dayId = calendarDay.id,
//                    startTime = it.startTime,
//                    endTime = it.endTime
//                )
//            )
//
//            alcoholDao.insert(
//                it.alcoItems.map {
//                    AlcoholDb(sessionId = it.id, name = it.name)
//                }
//            )
//
//            calendarDailyDao.insert(
//                CalendarDailyDb(
//                    id = calendarDay.id,
//                    name = calendarDay.name,
//                    number = calendarDay.number
//                )
//            )
//        }
//    }
//
//    fun getAllDays(): List<CalendarDay> {
//        val daysDb = calendarDailyDao.getAllDays()
//
//        return daysDb.map {
//            val session = alcoSessionDao.findSessionByDayId(it.id)
//            val alcoholList = alcoholDao.findAlcoholBySessionId(session.id)
//
//            CalendarDay(
//                id = it.id,
//                name = it.name,
//                number = it.number,
//                dailySessions = AlcoSession(
//                    id = session.id,
//                    startTime = session.startTime,
//                    endTime = session.endTime,
//                    alcoItems = alcoholList.map { Alcohol(it.id!!, it.name) }
//                )
//            )
//        }
//    }

//    fun getDayById(): CalendarDay {
//        val daysDb = calendarDailyDao.getAllDays()
//
//        return daysDb.map {
//            val session = alcoSessionDao.findSessionByDayId(it.id)
//            val alcoholList = alcoholDao.findAlcoholBySessionId(session.id)
//
//            CalendarDay(
//                id = it.id,
//                name = it.name,
//                number = it.number,
//                dailySessions = AlcoSession(
//                    id = session.id,
//                    startTime = session.startTime,
//                    endTime = session.endTime,
//                    alcoItems = alcoholList.map { Alcohol(it.id!!, it.name) }
//                )
//            )
//        }
//    }
}