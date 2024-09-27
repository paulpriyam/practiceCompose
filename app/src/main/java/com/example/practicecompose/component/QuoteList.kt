package com.example.practicecompose.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practicecompose.model.Quote

@Preview
@Composable
fun QuoteList(
    data: List<Quote> = listOf(
        Quote(text = "To Kill a Mockingbird", category = "Harper Lee"),
        Quote(text = "1984", category = "George Orwell"),
        Quote(text = "To Kill a Mockingbird", category = "Harper Lee"),
        Quote(text = "To Kill a Mockingbird", category = "Harper Lee"),
        Quote(text = "To Kill a Mockingbird", category = "Harper Lee")
    ),
    modifier: Modifier = Modifier.fillMaxSize(),
    paddingTop: PaddingValues = PaddingValues(40.dp)
) {
    LazyColumn(
        modifier = Modifier.padding(paddingTop).padding(horizontal = 8.dp),
        content = {
            items(data) {
                QuoteItem(it)
            }
        })
}