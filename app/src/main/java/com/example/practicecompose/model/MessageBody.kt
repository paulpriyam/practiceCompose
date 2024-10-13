package com.example.practicecompose.model

import java.util.UUID

data class SendRequest(
    val destinationToken:String,
    val adminId:String = UUID.randomUUID().toString(),
    val adminToken:String,
    val requestTime:Long,
    val title:String,
    val message:String
)

data class RespondRequest(
    val destinationToken: String
)


