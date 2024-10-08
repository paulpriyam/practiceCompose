package com.example.practicecompose.component

import android.graphics.drawable.Drawable
import android.widget.ImageButton
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practicecompose.R
import com.example.practicecompose.ui.theme.black
import com.example.practicecompose.ui.theme.outlinedButtonTextColor
import com.example.practicecompose.ui.theme.solidButtonDisabledColor
import com.example.practicecompose.ui.theme.solidButtonsDisabledTextColor
import com.example.practicecompose.ui.theme.yellow


@Composable
fun SolidYellowButton(
    modifier: Modifier = Modifier,
    text: String = "Masuk Sebagai Owner",
    isEnabled: Boolean = true,
    onButtonClick: () -> Unit = {}
) {
    Button(
        onClick = onButtonClick,
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonColors(
            containerColor = yellow,
            contentColor = black,
            disabledContainerColor = solidButtonDisabledColor,
            disabledContentColor = solidButtonsDisabledTextColor,
        ),
        enabled = isEnabled
    ) {
        Text(text = text)
    }
}


@Composable
fun OutlinedButton(
    modifier: Modifier = Modifier,
    text: String = "Masuk Sebagai Admin",
    isEnabled: Boolean = true,
    onButtonClick: () -> Unit = {}
) {
    Button(
        onClick = onButtonClick,
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(width = 1.dp, brush = SolidColor(Color.Gray)),
        colors = ButtonColors(
            containerColor = Color.White,
            contentColor = outlinedButtonTextColor,
            disabledContainerColor = solidButtonDisabledColor,
            disabledContentColor = solidButtonsDisabledTextColor,
        ),
        enabled = isEnabled
    ) {
        Text(text = text)
    }
}


@Composable
fun ButtonWithDrawables(
    modifier: Modifier = Modifier,
    containerColor: Color = Color.White,
    contentColor: Color = black,
    text: String = "Dashboard",
    textStyle: TextStyle = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Bold),
    borderStroke: BorderStroke? = BorderStroke(width = 1.dp, brush = SolidColor(Color.Gray)),
    shape: Shape = RoundedCornerShape(16.dp),
    rightDrawable: Int? = R.drawable.ic_chevron_right,
    leftDrawable: Int? = R.drawable.ic_dashboard,
    rightOnClick: () -> Unit = {},
    leftOnClick: () -> Unit = {}

) {

    Surface(
        modifier = modifier,
        shape = shape, border = borderStroke, color = containerColor
    ) {

        Row(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            leftDrawable?.let {
                Image(
                    painter = painterResource(leftDrawable),
                    contentDescription = "left icon"
                )
            }

            Spacer(Modifier.width(8.dp))
            Text(text = text, style = textStyle)
            Spacer(Modifier.width(8.dp))
            rightDrawable?.let {
                Image(
                    painter = painterResource(rightDrawable),
                    contentDescription = "right icon"
                )
            }

        }
    }
}