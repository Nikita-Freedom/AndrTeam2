package com.hackaton.andrteam.alcoholdiary.data.network.api

import com.hackaton.andrteam.alcoholdiary.data.network.entity.User
import retrofit2.http.GET

interface UserApiService {

    @GET("/")
    fun getUser(): User
}