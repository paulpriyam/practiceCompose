package com.example.practicecompose.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practicecompose.model.Quote
import com.example.practicecompose.repository.QuoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(private val repository: QuoteRepository) : ViewModel() {

    private val _quotes = MutableStateFlow<ArrayList<Quote>>(arrayListOf())
    val quotes = _quotes.asStateFlow()

    fun getQuotes() {
        viewModelScope.launch {
            val response = repository.getQuotes()
            if (response.isSuccessful) {
                _quotes.emit(response.body() ?: arrayListOf())
            } else {
                _quotes.emit(arrayListOf())
            }
        }
    }
}