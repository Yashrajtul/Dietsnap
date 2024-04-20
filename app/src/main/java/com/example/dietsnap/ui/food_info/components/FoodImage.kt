package com.example.dietsnap.ui.food_info.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dietsnap.R

@Composable
fun Stock(
    modifier: Modifier = Modifier,
    rating: Int
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(70.dp, 77.dp)
            .background(
                color = Color(0xA68B8B8B),
                shape = RoundedCornerShape(16.dp)
            )
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = rating.toString(),
                color = Color.White,
                fontFamily = FontFamily(Font(R.font.inter_bold)),
                fontSize = 20.sp,
                lineHeight = 24.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "out of 100",
                color = Color.White,
                fontFamily = FontFamily(Font(R.font.inter_bold)),
                fontSize = 8.sp,
                lineHeight = 10.sp
            )
        }
    }
}

@Composable
fun FoodInfo(
    modifier: Modifier = Modifier,
    title: String
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = "Food Information",
            color = Color.White,
            fontFamily = FontFamily(Font(R.font.inter_bold)),
            fontSize = 15.sp,
            lineHeight = 18.sp
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = title,
            color = Color.White,
            fontFamily = FontFamily(Font(R.font.inter_bold)),
            fontSize = 28.sp,
            lineHeight = 34.sp,
            modifier = Modifier.padding(2.dp)
        )
    }
}

@Composable
fun FoodImage(
    modifier: Modifier = Modifier,
    image: Int,
    name: String,
    rating: Int,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(317.dp)
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = name,
            contentScale = ContentScale.Crop,
            alignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0x69000000))
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
//                modifier = Modifier.statusBarsPadding()
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                    contentDescription = "back arrow",
                    tint = Color.White,
                    modifier = Modifier
                        .size(30.dp, 40.dp)
                        .clickable(onClick = onClick)
                )
                Text(
                    text = "Back",
                    color = Color.White,
                    fontFamily = FontFamily(Font(R.font.inter_regular)),
                    fontSize = 17.sp,
                    lineHeight = 21.sp
                )
            }
            FoodInfo(
                title = name,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(20.dp)
            )
            Stock(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(31.dp, 13.dp),
                rating = rating
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun StockPreview() {
    Stock(rating = 71)
}

@Preview
@Composable
private fun FoodInfoPreview() {
    FoodInfo(title = "Fried Chicken")
}

@Preview(showSystemUi = true)
@Composable
private fun FoodImagePreview() {
    FoodImage(
        image = R.drawable.chicken_biryani,
        name = "Fried Chicken",
        rating = 71,
        onClick = {}
    )
}