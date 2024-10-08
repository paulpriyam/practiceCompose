package com.example.practicecompose.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practicecompose.model.Quote

@Preview(showBackground = true)
@Composable
fun QuoteDetail(
    modifier: Modifier = Modifier,
    quote: Quote = Quote(text = "The Chronicles of Narnia", category = "C.S. Lewis"),
) {
    Box(
        modifier = modifier
            .fillMaxSize(1f), contentAlignment = Alignment.Center

    ) {

        Card(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(200.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {

                Image(
                    imageVector = Icons.Filled.FormatQuote,
                    contentDescription = null,
                    modifier = Modifier
                        .size(50.dp)
                        .rotate(180f)
                )
                Spacer(Modifier.height(8.dp))
                Text(
                    text = quote.text,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(text = quote.category, modifier = Modifier.padding(8.dp, 16.dp, 0.dp, 0.dp))
            }
        }
    }
}