package com.hackaton.andrteam.alcoholdiary.domain.model

import java.util.*

data class AlcoSession(
    val id: Int,
    val startTime: Date,
    val endTime: Date,
    val alcoItems: List<Alcohol>
)