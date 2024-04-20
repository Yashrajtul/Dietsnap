package com.example.dietsnap.ui.food_info.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FactUnit(
    cardColor: Color,
    text: String
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = cardColor),
        modifier = Modifier
            .padding(end = 6.dp)
            .size(343.dp, 184.dp)
    ) {
        Column(
//            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp, 20.dp)
        ) {
            Text(
                text = "Did you Know?",
                color = Color.White,
                fontSize = 18.sp,
                lineHeight = 22.sp,
                modifier = Modifier.padding(horizontal = 40.dp, vertical = 7.dp)
            )
            Text(
                text = text,
                color = Color.White,
                fontSize = 17.sp,
                lineHeight = 21.sp,
                modifier = Modifier.padding(vertical = 7.dp)
            )
        }
    }
}


@Composable
fun Facts(
    facts: List<String>
) {
    val factColors = listOf(
        Color(0xCCF8B944),
        Color(0xCCFA9D5A)
    )
    Column {
        SubHeading(title = "Facts")
        LazyRow(
            contentPadding = PaddingValues(16.dp)
        ) {
            itemsIndexed(facts) { index, fact ->
                FactUnit(
                    cardColor = if (index % 2 == 0) factColors[0] else factColors[1],
                    text = fact
                )

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun FactUnitPreview() {
    FactUnit(
        Color(0xCCF8B944),
        text = "There are more chickens on earth than people – 25 billion. There are also more chickens than any other bird species.",
    )
}

@Preview(showSystemUi = true)
@Composable
private fun FactsPreview() {
    Facts(
        facts = listOf(
            "There are more chickens on earth than people – 25 billion. There are also more chickens than any other bird species.",
            "There are more chickens on earth than people – 25 billion. There are also more chickens than any other bird species.",
            "There are more chickens on earth than people – 25 billion. There are also more chickens than any other bird species.",
            "There are more chickens on earth than people – 25 billion. There are also more chickens than any other bird species."
        )
    )
}