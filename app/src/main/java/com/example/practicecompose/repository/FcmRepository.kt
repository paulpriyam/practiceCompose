package com.example.practicecompose.repository

import com.example.practicecompose.model.RespondRequest
import com.example.practicecompose.model.SendRequest
import com.example.practicecompose.service.FcmApi
import javax.inject.Inject

class FcmRepository @Inject constructor(private val fcmApi: FcmApi) {

    suspend fun sendMessage(sendRequest: SendRequest) = fcmApi.sendMessage(sendRequest)

    suspend fun acceptRequest(respondRequest: RespondRequest) = fcmApi.acceptRequest(respondRequest)

    suspend fun denyRequest(respondRequest: RespondRequest) = fcmApi.denyRequest(respondRequest)
}