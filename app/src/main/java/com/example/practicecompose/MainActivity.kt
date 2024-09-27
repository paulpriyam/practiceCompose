package com.example.practicecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.practicecompose.screens.QuoteListScreen
import com.example.practicecompose.ui.theme.PracticeComposeTheme
import com.example.practicecompose.util.FileManager
import com.example.practicecompose.viewmodel.QuoteViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val viewModel:QuoteViewModel by viewModels()
        setContent {
            PracticeComposeTheme {
                App(viewModel)
            }
        }
    }
}

@Composable
fun App(viewModel:QuoteViewModel) {
    val context = LocalContext.current
    val state  = viewModel.quotes.collectAsStateWithLifecycle()
    LaunchedEffect(true) {
        viewModel.getQuotes()
    }

    if (state.value.isNotEmpty()) {
        QuoteListScreen(state.value)
    } else {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }

}