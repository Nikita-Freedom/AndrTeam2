package com.hackaton.andrteam.alcoholdiary.data.network.mapper

import com.hackaton.andrteam.alcoholdiary.data.network.entity.User
import com.hackaton.andrteam.alcoholdiary.domain.model.User as UserDomain

fun User.toDomain(): UserDomain {
    return UserDomain()
}
