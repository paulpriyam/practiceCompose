package com.example.practicecompose.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.practicecompose.component.QuoteDetail
import com.example.practicecompose.model.Quote

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuoteDetailsScreen(
    quote: Quote = Quote(
        title = "The Chronicles of Narnia",
        author = "C.S. Lewis"
    )
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text("Detail Screen",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center)
                },
                navigationIcon = {
                    IconButton(onClick = {

                    }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = null
                        )
                    }
                }
            )
        },
        containerColor = MaterialTheme.colorScheme.onPrimaryContainer) { paddingValues ->
        QuoteDetail(quote)

    }

}