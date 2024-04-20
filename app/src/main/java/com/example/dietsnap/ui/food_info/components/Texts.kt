package com.example.dietsnap.ui.food_info.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dietsnap.R

@Composable
fun SubHeading(
    modifier: Modifier = Modifier,
    title: String
) {
    Text(
        text = title,
        fontFamily = FontFamily(Font(R.font.inter_bold)),
        fontSize = 22.sp,
        lineHeight = 27.sp,
        modifier = modifier
            .padding(horizontal = 16.dp)
    )
}

@Preview(showBackground = true)
@Composable
private fun SubHeadingPreview() {
    SubHeading(title = "Description")
}
