package com.example.practicecompose.repository

import com.example.practicecompose.service.QuoteApi
import javax.inject.Inject

class QuoteRepository @Inject constructor(private val api: QuoteApi) {

    suspend fun getQuotes()= api.getQuotes()
}