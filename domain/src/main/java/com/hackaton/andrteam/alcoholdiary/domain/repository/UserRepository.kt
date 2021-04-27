package com.hackaton.andrteam.alcoholdiary.domain.repository

import com.hackaton.andrteam.alcoholdiary.domain.model.User

interface UserRepository {

    fun getUser(): User
}