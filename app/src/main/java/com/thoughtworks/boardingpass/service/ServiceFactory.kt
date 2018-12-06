package com.thoughtworks.boardingpass.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceFactory {

    fun boardingPassService(): BoardingPassService {
        return retrofit().create(BoardingPassService::class.java)
    }

    private fun retrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://5c095f4fea3172001389cd6c.mockapi.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}