package com.example.practicecompose.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.practicecompose.component.QuoteList
import com.example.practicecompose.viewmodel.QuoteViewModel
import com.google.gson.Gson

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuoteListScreen(viewModel: QuoteViewModel, navController: NavController) {

    val state = viewModel.quotes.collectAsStateWithLifecycle()
    LaunchedEffect(true) {
        viewModel.getQuotes()
    }
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(
                    text = "List Screen",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            })
        }, containerColor = MaterialTheme.colorScheme.onPrimaryContainer
    ) { padding ->
        if (state.value.isNotEmpty()) {
            QuoteList(state.value, paddingTop = padding) { quote ->
                val quoteJson = Gson().toJson(quote)
                navController.navigate("QuoteDetail/$quoteJson")
            }
        } else {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

    }
}





