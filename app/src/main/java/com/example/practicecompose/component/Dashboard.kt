package com.example.practicecompose.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practicecompose.R
import com.example.practicecompose.ui.theme.black
import com.example.practicecompose.ui.theme.primaryBlue
import com.google.accompanist.pager.HorizontalPagerIndicator


@Composable
fun ProfileCard(
    modifier: Modifier = Modifier,
    profileIcon: Int = R.drawable.ic_profile,
    profileName: String = "Juragan Adjie",
    badges: List<String> = listOf("Data Diri", "Bisnis", "new"),
    settingsIcon: Int = R.drawable.ic_settings
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(8.dp), border = BorderStroke(
            width = 1.dp, brush = SolidColor(
                Color.Gray
            )
        )
    ) {
        Row(
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.ic_profile),
                contentDescription = "profile picture"
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "Halo,", style = TextStyle(fontSize = 14.sp))
                Spacer(Modifier.height(8.dp))
                Text(
                    text = profileName,
                    style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold)
                )
                Spacer(Modifier.height(8.dp))
                LazyRow {
                    items(badges) {
                        ButtonWithDrawables(
                            modifier = Modifier.padding(horizontal = 4.dp),
                            text = it,
                            shape = RoundedCornerShape(16.dp),
                            rightDrawable = R.drawable.ic_green_badge,
                            leftDrawable = null
                        )
                    }
                }
            }
            Image(
                painter = painterResource(R.drawable.ic_settings),
                contentDescription = "settings icon"
            )
        }
    }
}

@Composable
fun SaldoCard(
    modifier: Modifier = Modifier,
    amount: String = "125000"
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, brush = SolidColor(Color.Gray))
    ) {
        var isBalanceVisible by remember { mutableStateOf(false) }

        Row(modifier = Modifier.padding(16.dp), horizontalArrangement = Arrangement.SpaceBetween) {
            Column {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(R.drawable.ic_saldo_icon),
                        contentDescription = "saldo icon"
                    )
                    Spacer(Modifier.width(8.dp))
                    Text(text = "Saldo", fontSize = 12.sp)
                    Spacer(Modifier.width(8.dp))
                    Image(
                        modifier = Modifier
                            .size(24.dp)
                            .clickable {
                                isBalanceVisible = !isBalanceVisible
                            },
                        imageVector = if (isBalanceVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                        colorFilter = ColorFilter.tint(color = Color.Gray),
                        contentDescription = "hide show icon"
                    )
                }
                Spacer(Modifier.height(4.dp))
                Text(
                    text = if (isBalanceVisible) "Rp$amount" else "Rp*****",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
            }
            ButtonWithDrawables(
                text = "Top Up",
                shape = RoundedCornerShape(8.dp),
                rightDrawable = R.drawable.ic_add,
                leftDrawable = null,
                borderStroke = null,
                containerColor = primaryBlue,
                textStyle = TextStyle(
                    fontSize = 16.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}


@Composable
fun RequestCard(
    modifier: Modifier = Modifier,
    expirationTime: String = "9:15",
    requestText: String = "Ada permintaan masuk untuk Admin123"
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal =16.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Kadaluwarsa dalam $expirationTime", fontSize = 12.sp, color = Color.Red)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = requestText, fontSize = 14.sp, fontWeight = FontWeight.Bold, color = black)
            Spacer(Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                OutlinedButton(modifier = Modifier.weight(1f), text = "Tolak")
                Spacer(Modifier.width(16.dp))
                SolidYellowButton(modifier = Modifier.weight(1f), text = "Izinkan")
            }
        }
    }
}


@Composable
fun RequestPager(
    modifier: Modifier = Modifier,
    requests: List<Pair<String, String>> = listOf(
        "9:16" to "Ada permintaan masuk untuk Admin123",
        "5:45" to "Ada permintaan masuk untuk User456",
        "2:30" to "Ada permintaan masuk untuk User789"
    )
) {
    val pagerState = rememberPagerState(pageCount = {
        requests.size
    })
    val coroutineScope = rememberCoroutineScope()

    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {

        HorizontalPager(state = pagerState) { pageNumber ->
            val request = requests[pageNumber]
            RequestCard(expirationTime = request.first, requestText = request.second)
        }

        Spacer(Modifier.height(8.dp))

        HorizontalPagerIndicator(
            pagerState = pagerState,
            pageCount = requests.size,
            activeColor = primaryBlue,
            inactiveColor = Color.Gray
        )
    }

}


@Composable
fun BusinessTabItem(
    modifier: Modifier = Modifier,
    businessName: String = "Toko Aneka Baut Maju Jaya L...",
    adminNames: List<String> = listOf("Ega", "Adjie", "Humairah"),
    businessImage: Int = R.drawable.ic_launcher_background,
    isLeftButton:Boolean=true,
    isRightButton:Boolean=true
) {
    val admins = adminNames.joinToString(" , ")
    Surface(
        modifier = modifier.fillMaxWidth(), border = BorderStroke(
            width = 1.dp, brush = SolidColor(
                Color.Gray
            )
        ),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            Row {
                Image(
                    painter = painterResource(businessImage),
                    contentDescription = "business image",
                    modifier = Modifier
                        .size(48.dp)
                        .clip(
                            CircleShape
                        )
                )
                Spacer(Modifier.width(8.dp))
                Column {
                    Text(text = businessName, style = TextStyle(fontWeight = FontWeight.Bold))
                    Spacer(Modifier.height(4.dp))
                    Text(text = "Admin: $admins")
                }

            }
            Spacer(Modifier.height(8.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                if(isLeftButton){
                    OutlinedButton(modifier = Modifier.weight(1f), text = "Detail")
                }
                Spacer(Modifier.width(16.dp))
                if(isRightButton){
                    ButtonWithDrawables(
                        modifier = Modifier
                            .height(48.dp)
                            .weight(1f),
                        leftDrawable = null,
                        text = "Buka",
                        shape = RoundedCornerShape(8.dp),
                        rightDrawable = R.drawable.ic_chevron_right,
                        containerColor = Color.White
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessList(modifier: Modifier = Modifier) {
    val businessList = listOf(
        Triple(
            "Toko Aneka Baut Maju Jaya L...",
            listOf("adjie", "hum"),
            R.drawable.ic_launcher_background
        ),
        Triple(
            "Toko Cahaya Abadi - Cab. 2",
            listOf("Bhanu", "Flo"),
            R.drawable.ic_launcher_background
        ),
        Triple("Toko Cahaya Abadi - Cab. 3", listOf("Daw"), R.drawable.ic_launcher_background),
        Triple(
            "Toko Cahaya Abadi - Cab. 1",
            listOf("Hendy", "Rohendy"),
            R.drawable.ic_launcher_background
        ),
        Triple(
            "Toko Aneka Baut",
            listOf("Hariom", "Kesa", "Naupal"),
            R.drawable.ic_launcher_background
        ),
        Triple(
            "Toko Cahaya Abadi - Cab. 5",
            listOf("Mandeep", "Arun"),
            R.drawable.ic_launcher_background
        )
    )
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(businessList) { business ->
            BusinessTabItem(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp, horizontal = 16.dp),
                businessName = business.first,
                adminNames = business.second,
                businessImage = business.third
            )
        }
    }
}


@Composable
fun BusinessUnderAdmin(modifier: Modifier = Modifier) {
    val businessList = listOf(
        Triple(
            "Toko Aneka Baut Maju Jaya L...",
            listOf("adjie", "hum"),
            R.drawable.ic_launcher_background
        ),
        Triple(
            "Toko Cahaya Abadi - Cab. 2",
            listOf("Bhanu", "Flo"),
            R.drawable.ic_launcher_background
        ),
        Triple("Toko Cahaya Abadi - Cab. 3", listOf("Daw"), R.drawable.ic_launcher_background),
        Triple(
            "Toko Cahaya Abadi - Cab. 1",
            listOf("Hendy", "Rohendy"),
            R.drawable.ic_launcher_background
        ),
        Triple(
            "Toko Aneka Baut",
            listOf("Hariom", "Kesa", "Naupal"),
            R.drawable.ic_launcher_background
        ),
        Triple(
            "Toko Cahaya Abadi - Cab. 5",
            listOf("Mandeep", "Arun"),
            R.drawable.ic_launcher_background
        )
    )
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(businessList) { business ->
            BusinessTabItem(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp, horizontal = 16.dp),
                businessName = business.first,
                adminNames = business.second,
                businessImage = business.third,
                isLeftButton = false,
                isRightButton = true
            )
        }
    }
}


@Composable
fun AdminTabItem(
    modifier: Modifier = Modifier,
    adminName: String = "Adjie",
    onClick: (name: String) -> Unit = {}
) {
    Surface(
        modifier = Modifier.fillMaxWidth(), border = BorderStroke(
            width = 1.dp, brush = SolidColor(
                Color.Gray
            )
        )
    ) {
        Row(modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
            Image(
                modifier = Modifier
                    .size(32.dp)
                    .clip(CircleShape),
                painter = painterResource(R.drawable.ic_launcher_background),
                contentDescription = "admin icon",
                alpha = 0.6f
            )
            Spacer(Modifier.width(8.dp))
            Text(text = adminName, modifier = Modifier.weight(1f))
            Spacer(Modifier.width(8.dp))
            Image(
                modifier = Modifier.clickable {
                    onClick.invoke(adminName)
                },
                painter = painterResource(R.drawable.ic_chevron_right), contentDescription = ""
            )
        }
    }
}

@Composable
fun AdminList(modifier: Modifier = Modifier) {
    val adminList = listOf("Adjie", "Flo", "Humairah", "Daw", "Hendy", "Pramudiana", "Muhaimin")
    LazyColumn {
        items(adminList) {
            AdminTabItem(
                adminName = it,
                onClick = { name ->

                }
            )
        }
    }
}


@Composable
fun BusinessAndAdminTabs(modifier: Modifier = Modifier) {
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    val tabs = listOf("Bisnis Anda", "Admin")

    Column(
        modifier = modifier
            .background(color = Color.White)
    ) {
        TabRow(
            modifier = Modifier.height(40.dp),
            selectedTabIndex = selectedTabIndex,
            backgroundColor = Color.White,
            contentColor = primaryBlue
        ) {
            tabs.forEachIndexed { index, s ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index })
                {
                    Text(text = s)
                }
            }
        }

        when (selectedTabIndex) {
            0 -> {
                BusinessList()
            }

            1 -> {
                AdminList()
            }
        }
    }

}

