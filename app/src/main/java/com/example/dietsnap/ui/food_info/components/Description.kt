package com.example.dietsnap.ui.food_info.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dietsnap.R

@Composable
fun Description(description: String) {
    Column {
        SubHeading(title = "Description", modifier = Modifier.padding(top = 6.dp))
        Text(
            text = description,
            fontFamily = FontFamily(Font(R.font.inter_regular)),
            fontSize = 17.sp,
            lineHeight = 21.sp,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showSystemUi = true)
@Composable
private fun DescriptionPreview() {
    Description(
        "Fried chicken is a dish consisting of chicken pieces usually from broiler chickens which have been floured or battered and then pan-fried, deep fried, or pressure fried."
    )
}