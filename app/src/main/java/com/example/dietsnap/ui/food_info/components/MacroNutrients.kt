package com.example.dietsnap.ui.food_info.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dietsnap.R
import com.example.dietsnap.data.remote.dto.FoodResponse
import com.example.dietsnap.nutritionScaledInfo
import kotlin.math.roundToInt

@Composable
fun NutrientTable(
    noOfServings: Float,
    nutritionScaledInfo: List<FoodResponse.Data.NutritionScaledInfo>
) {
    Card(
        colors = CardDefaults.cardColors(Color(0xFFFDF7F7)),
        border = BorderStroke(1.dp, Color(0xFF707070)),
        modifier = Modifier.width(240.dp)
    ) {
        Column {
            Row(
                Modifier.padding(vertical = 8.dp)
            ) {
                Spacer(modifier = Modifier.width(111.dp))
                Text(
                    text = "Per Serve",
                    fontFamily = FontFamily(Font(R.font.inter_medium)),
                    fontSize = 10.sp,
                    lineHeight = 12.sp
                )
                Spacer(modifier = Modifier.width(24.dp))
                Text(
                    text = "Per 250gm",
                    fontFamily = FontFamily(Font(R.font.inter_medium)),
                    fontSize = 10.sp,
                    lineHeight = 12.sp
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Black)
                    .height(1.dp)
            )
            LazyColumn(
                modifier = Modifier.padding(horizontal = 13.dp, vertical = 8.dp)
            ) {
                items(nutritionScaledInfo) { nutrients ->
                    if ((nutrients.units == "kCal" || nutrients.units == "gms") && nutrients.value > 0.1f) {
                        Row {
                            Text(
                                text = nutrients.name,
                                fontFamily = FontFamily(Font(R.font.inter_medium)),
                                fontSize = 10.sp,
                                lineHeight = 12.sp,
                                modifier = Modifier.width(82.dp)
                            )
                            Spacer(modifier = Modifier.width(20.dp))
                            Text(
                                text = "${
                                    if ((nutrients.value / noOfServings) >= 1f) (nutrients.value / noOfServings).roundToInt()
                                    else (nutrients.value / noOfServings * 10).roundToInt()/10.0
                                } ${if (nutrients.units == "kCal") "J" else "gm"}",
                                color = Color(0xFF707070),
                                fontFamily = FontFamily(Font(R.font.inter_regular)),
                                fontSize = 10.sp,
                                lineHeight = 12.sp,
                                modifier = Modifier.width(40.dp)
                            )
                            Spacer(modifier = Modifier.width(30.dp))
                            Text(
                                text = "${if (nutrients.value >= 2f) nutrients.value.roundToInt() else (nutrients.value * 10).roundToInt()/10.0} ${if (nutrients.units == "kCal") "J" else "gm"}",
                                color = Color(0xFF707070),
                                fontFamily = FontFamily(Font(R.font.inter_regular)),
                                fontSize = 10.sp,
                                lineHeight = 12.sp,
                                modifier = Modifier.width(40.dp)
                            )
                        }
                    }
                }

            }
        }
    }
}

@Composable
fun MacroNutrients(
    noOfServings: Float,
    nutritionScaledInfo: List<FoodResponse.Data.NutritionScaledInfo>
) {
    Column {
        SubHeading(title = "Macro Nutrients")
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            NutrientTable(noOfServings, nutritionScaledInfo)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun NutrientTablePreview() {
    NutrientTable(4f, nutritionScaledInfo)
}

@Preview(showSystemUi = true)
@Composable
private fun MacroNutrientsPreview() {
    MacroNutrients(4f, nutritionScaledInfo)
}