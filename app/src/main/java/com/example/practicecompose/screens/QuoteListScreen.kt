package com.example.practicecompose.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.practicecompose.component.QuoteList
import com.example.practicecompose.model.Quote

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuoteListScreen(data:List<Quote>) {
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
        QuoteList(data,paddingTop = padding)
    }
}





