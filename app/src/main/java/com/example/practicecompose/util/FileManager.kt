package com.example.practicecompose.util

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.practicecompose.model.Quote
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.io.InputStreamReader


object FileManager {

    val data = arrayListOf<Quote>()
    val _loading = mutableStateOf(true)
    fun loadDataFromAsset(context: Context) {
        val inputSteam = context.assets.open("quotes.json")
        val reader = InputStreamReader(inputSteam)
        val gson = Gson()
        val quoteType = object : TypeToken<List<Quote>>() {}.type
        val quotes = gson.fromJson<List<Quote>>(reader, quoteType)
        data.addAll(quotes)
        _loading.value = false
        reader.close()
    }


}