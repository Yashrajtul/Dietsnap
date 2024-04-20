package com.example.dietsnap.ui.home.bottomnav

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dietsnap.R
import com.example.dietsnap.ui.theme.LightGrey
import com.example.dietsnap.ui.theme.NavGrey
import com.example.dietsnap.ui.theme.UnselectedNav

data class BottomNavigationItem(
    val title: String,
    val icon: Painter
)

@Composable
fun BottomNavigation() {
    val items = listOf(
        BottomNavigationItem("Activity", painterResource(id = R.drawable.activity_icon)),
        BottomNavigationItem("Goals", painterResource(id = R.drawable.graph)),
        BottomNavigationItem("Camera", painterResource(id = R.drawable.camera)),
        BottomNavigationItem("Feed", painterResource(id = R.drawable.menu)),
        BottomNavigationItem("Profile", painterResource(id = R.drawable.person))
    )
    var selectedItemIndex by rememberSaveable {
        mutableIntStateOf(0)
    }
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(2.dp)
                .background(LightGrey)
        )
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(NavGrey)
        ) {
            items.forEachIndexed { index, item ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    IconButton(onClick = {
                        selectedItemIndex = index
                    }) {
                        Icon(
                            painter = item.icon,
                            contentDescription = item.title,
                            tint = if (index == selectedItemIndex) Color.Black else UnselectedNav
                        )
                    }
                    Text(
                        text = item.title,
                        style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.inter_regular)),
                            fontSize = 10.sp,
                            color = if (index == selectedItemIndex) Color.Black else UnselectedNav
                        )
                    )
                }

            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun BottomNavigationPreview() {
    BottomNavigation()
}