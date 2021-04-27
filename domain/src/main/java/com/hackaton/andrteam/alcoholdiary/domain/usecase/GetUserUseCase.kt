package com.hackaton.andrteam.alcoholdiary.domain.usecase

import com.hackaton.andrteam.alcoholdiary.domain.model.User
import com.hackaton.andrteam.alcoholdiary.domain.repository.UserRepository

class GetUserUseCase(
    private val userRepository: UserRepository
) {

    fun getUser(): User {
        return userRepository.getUser()
    }
}