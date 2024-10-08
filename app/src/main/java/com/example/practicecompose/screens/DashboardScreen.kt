package com.example.practicecompose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.practicecompose.R
import com.example.practicecompose.bottomsheet.BusinessBottomSheet
import com.example.practicecompose.component.BusinessAndAdminTabs
import com.example.practicecompose.component.ButtonWithDrawables
import com.example.practicecompose.component.OutlinedButton
import com.example.practicecompose.component.ProfileCard
import com.example.practicecompose.component.RequestPager
import com.example.practicecompose.component.SaldoCard
import kotlinx.coroutines.launch

@Preview
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BusinessDashboard(
    modifier: Modifier = Modifier,
    requests: List<Pair<String, String>> = listOf(
        "9:16" to "Ada permintaan masuk untuk Admin123",
        "5:45" to "Ada permintaan masuk untuk User456",
        "2:30" to "Ada permintaan masuk untuk User789"
    )
) {
    val bottomSheetState = androidx.compose.material.rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        skipHalfExpanded = true
    )
    val coroutineScope = rememberCoroutineScope()
    val businessList = listOf(
        "Dashboard",
        "Toko Cahaya Abadi - Cab. 1",
        "Toko Cahaya Abadi - Cab. 2",
        "Toko Aneka Baut Maju Jaya L..."
    )
    var selectedBusiness by remember { mutableStateOf(businessList[0]) }

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        // Define elements and guidelines
        val (topSection, content, createBusinessButton) = createRefs()
        val topGuide = createGuidelineFromTop(0.1f)

        // TopSection (background)
        TopSection(
            modifier = Modifier
                .constrainAs(topSection) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                }
        ){
            coroutineScope.launch {
                bottomSheetState.show()
            }
        }

        // Main content (foreground)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
                .constrainAs(content) {
                    top.linkTo(topGuide) // Align to the guideline
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(createBusinessButton.top) // Link to the button's top
                    height = Dimension.fillToConstraints // Make the LazyColumn fill available space
                },
            // Add padding to avoid overlapping with the button
        ) {
            if (requests.isNotEmpty()) {
                RequestPager(Modifier, requests)
            }
            Spacer(Modifier.height(8.dp))
            ProfileCard()
            Spacer(Modifier.height(8.dp))
            SaldoCard()
            BusinessAndAdminTabs()

        }

        // Create New Business Button
        CreateNewBusinessButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
                .constrainAs(createBusinessButton) {
                    bottom.linkTo(parent.bottom) // Align to the bottom of the screen
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

    }
    BusinessBottomSheet(
        bottomSheetState = bottomSheetState,
        businessList = businessList,
        selectedBusiness = "Toko Cahaya Abadi - Cab. 1"
    ) { business ->
        selectedBusiness = business
        coroutineScope.launch {
            bottomSheetState.hide()
        }
    }
}

@Composable
fun TopSection(modifier: Modifier = Modifier, onclick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp)
            .clip(RoundedCornerShape(bottomEnd = 32.dp, bottomStart = 32.dp))
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF007BFF), // Start color
                        Color(0xFF8AB4F8)
                    )
                )
            )
    )
    {
//Dashboard icon
        ButtonWithDrawables(
            modifier = Modifier.padding(vertical = 20.dp, horizontal = 16.dp),
            text = "Dashboard",
            leftDrawable = R.drawable.ic_dashboard,
            rightDrawable = R.drawable.ic_chevron_right,
            rightOnClick = {
                onclick.invoke()
            }
        )
    }
}

@Composable
fun CreateNewBusinessButton(modifier: Modifier = Modifier) {
    OutlinedButton(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        text = "Buat Bisnis Baru"
    )
}

