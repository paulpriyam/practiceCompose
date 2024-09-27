package com.example.practicecompose.service

import com.example.practicecompose.model.Quote
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApi {

@GET("MXHU")
suspend fun getQuotes(): Response<ArrayList<Quote>>
}