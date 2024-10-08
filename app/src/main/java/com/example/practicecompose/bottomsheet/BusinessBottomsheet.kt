package com.example.practicecompose.bottomsheet

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomSheetState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practicecompose.R
import kotlinx.coroutines.launch
import kotlin.math.truncate

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BusinessBottomSheet(
    modifier: Modifier = Modifier,
    bottomSheetState: ModalBottomSheetState,
    businessList: List<String>,
    selectedBusiness: String,
    onSelectBusiness: (String) -> Unit
) {



    ModalBottomSheetLayout(
        sheetState = bottomSheetState,
        sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        sheetContent = {
            BottomSheetContent(
                businessList = businessList,
                selectedBusiness = selectedBusiness
            )
            { business ->
                onSelectBusiness.invoke(business)
            }
        }
    ) {

    }
}


@Composable
fun BottomSheetContent(
    modifier: Modifier = Modifier,
    businessList: List<String> = listOf(
        "Dashboard",
        "Toko Cahaya Abadi - Cab. 1",
        "Toko Cahaya Abadi - Cab. 2",
        "Toko Aneka Baut Maju Jaya L..."
    ),
    selectedBusiness: String = "Dashboard",
    onSelectBusiness: (String) -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    )
    {
        Text(
            text = "Pindah Bisnis",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 16.dp)
        )
        businessList.forEach { business ->
            BusinessListItem(
                businessName = business,
                isSelected = business == selectedBusiness,
                onSelect = { onSelectBusiness(business) }
            )

        }

    }

}


@Composable
fun BusinessListItem(
    modifier: Modifier = Modifier,
    businessName: String = "Dashboard",
    isSelected: Boolean = true,
    onSelect: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(color = if (isSelected) Color(0xFFE0F7FA) else Color.Transparent)
            .clickable { onSelect.invoke() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(R.drawable.ic_dashboard),
            contentDescription = "business icon",
            modifier = Modifier.size(40.dp)
        )
        Spacer(Modifier.width(8.dp))
        Text(
            text = businessName,
            fontSize = 16.sp,
            color = if (isSelected) Color.Black else Color.Gray,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
        )
    }
}