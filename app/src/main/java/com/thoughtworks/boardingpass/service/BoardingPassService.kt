package com.thoughtworks.boardingpass.service

import com.thoughtworks.boardingpass.model.BoardingPass
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface BoardingPassService {

    @GET("boardingPass/{id}")
    fun boardingPassById(@Path("id") id: String): Call<BoardingPass>

    @GET("boardingPass")
    fun allBoardingPasses(): Call<List<BoardingPass>>

}