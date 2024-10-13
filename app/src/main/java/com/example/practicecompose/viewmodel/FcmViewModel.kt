package com.example.practicecompose.viewmodel

import androidx.lifecycle.ViewModel
import com.example.practicecompose.repository.FcmRepository
import javax.inject.Inject

class FcmViewModel @Inject constructor(private val fcmRepository: FcmRepository) : ViewModel() {
}