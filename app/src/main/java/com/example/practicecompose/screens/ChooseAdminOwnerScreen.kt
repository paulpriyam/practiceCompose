package com.example.practicecompose.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practicecompose.R
import com.example.practicecompose.component.OutlinedButton
import com.example.practicecompose.component.SolidYellowButton

@Preview
@Composable
fun ChooseAdminOwnerScreen(
    modifier: Modifier = Modifier,
) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)
        .padding(16.dp)) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            painter = painterResource(R.drawable.ic_choose_admin_owner),
            contentDescription = "choose user"
        )
        Spacer(Modifier.height(16.dp))
        OutlinedButton(
            text = "Masuk Sebagai Admin",
            onButtonClick = {

            }
        )
        Spacer(Modifier.height(16.dp))
        SolidYellowButton(text = "Masuk Sebagai Owner", onButtonClick = {})
    }
}