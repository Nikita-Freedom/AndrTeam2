package com.hackaton.andrteam.alcoholdiary.data.network.api

import retrofit2.Retrofit

object RetrofitApi {

        //TODO: change on our url
        private const val BASE_URL = " https://www.MYAPI.com"

        private fun retrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .build()
        }

    //TODO: It is example, better to use function
    val RETROFIT_SERVICE_USER: UserApiService by lazy {
            retrofit().create(UserApiService::class.java)
        }
}