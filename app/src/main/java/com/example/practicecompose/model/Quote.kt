package com.example.practicecompose.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Quote(
    val text: String,
    val category: String
):Parcelable
