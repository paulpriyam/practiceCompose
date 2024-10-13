package com.example.practicecompose.service

import com.example.practicecompose.model.RespondRequest
import com.example.practicecompose.model.SendRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface FcmApi {

    @POST("/send")
    suspend fun sendMessage(@Body sendRequest: SendRequest): Response<Unit>

    @POST("/accept")
    suspend fun acceptRequest(@Body respondRequest: RespondRequest): Response<Unit>

    @POST("/deny")
    suspend fun denyRequest(@Body respondRequest: RespondRequest): Response<Unit>
}