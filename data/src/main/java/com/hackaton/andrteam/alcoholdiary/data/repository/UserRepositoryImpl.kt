package com.hackaton.andrteam.alcoholdiary.data.repository

import com.hackaton.andrteam.alcoholdiary.data.network.api.UserApiService
import com.hackaton.andrteam.alcoholdiary.data.network.entity.User
import com.hackaton.andrteam.alcoholdiary.data.network.mapper.toDomain
import com.hackaton.andrteam.alcoholdiary.data.storage.StorageManager
import com.hackaton.andrteam.alcoholdiary.domain.model.User as UserDomain
import com.hackaton.andrteam.alcoholdiary.domain.repository.UserRepository

class UserRepositoryImpl(
    private val userApiService: UserApiService,
    private val storageManager: StorageManager
) : UserRepository {

    override fun getUser(): UserDomain {
        return User().toDomain()
    }
}