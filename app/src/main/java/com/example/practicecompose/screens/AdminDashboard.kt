package com.example.practicecompose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.practicecompose.bottomsheet.BusinessBottomSheet
import com.example.practicecompose.component.BusinessUnderAdmin
import com.example.practicecompose.component.ProfileCard
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AdminDashboard(
    modifier: Modifier = Modifier
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
    )

    {
        val (topSection, mainSection) = createRefs()
        val topGuide = createGuidelineFromTop(0.2f)


        TopSection(
            modifier = Modifier
                .constrainAs(topSection) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                }
        ) {
            coroutineScope.launch {
                bottomSheetState.show()
            }
        }
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
            .constrainAs(mainSection) {
                top.linkTo(topGuide)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            }) {
            Spacer(Modifier.height(8.dp))
            ProfileCard(badges = emptyList())
            Spacer(Modifier.height(8.dp))
            BusinessUnderAdminSection(Modifier.weight(1f))
        }


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
fun BusinessUnderAdminSection(
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        Text(
            text = "Bisnis Anda",
            modifier = Modifier.padding(start = 16.dp, top = 8.dp),
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 16.sp)
        )
        Spacer(Modifier.height(16.dp))
        BusinessUnderAdmin()

    }
}