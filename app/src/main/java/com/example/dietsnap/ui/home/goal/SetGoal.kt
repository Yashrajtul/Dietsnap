package com.example.dietsnap.ui.home.goal

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dietsnap.R
import com.example.dietsnap.ui.theme.DarkOrange
import com.example.dietsnap.ui.theme.DarkPurple
import com.example.dietsnap.ui.theme.DimGrey
import com.example.dietsnap.ui.theme.LightGrey
import com.example.dietsnap.ui.theme.MediumGrey
import com.example.dietsnap.ui.theme.MiddleOrange
import com.example.dietsnap.ui.theme.NavGrey
import com.example.dietsnap.ui.theme.ShadowPurple

@Composable
fun StatUnit(
    modifier: Modifier = Modifier,
    value: String,
    type: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.width(100.dp)
    ) {
        Text(
            text = value,
            fontFamily = FontFamily(Font(R.font.inter_regular)),
            fontSize = 15.sp,
            lineHeight = 21.sp,
            color = MiddleOrange
        )
        Text(
            text = type,
            fontFamily = FontFamily(Font(R.font.inter_regular)),
            fontSize = 14.sp,
            lineHeight = 17.sp
        )
    }
}


@Composable
fun Stats(
    totalCalories: Int,
    dayNo: Int,
    totalDays: Int,
    healthScore: Int
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(2.dp)
        ) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.apple_scale),
                    contentDescription = "apple_scale",
                    colorFilter = ColorFilter.tint(MiddleOrange)
                )
                Image(
                    painter = painterResource(id = R.drawable.apple_scale),
                    contentDescription = "apple_scale",
                    colorFilter = ColorFilter.tint(Color.Black),
                    modifier = Modifier
                        .alpha(.1f)
                        .offset((-.5).dp, 2.dp)
                        .blur(.9.dp)
                )

            }
            Text(
                text = "Diet Pts",
                fontFamily = FontFamily(Font(R.font.inter_regular)),
                fontSize = 14.sp,
                lineHeight = 17.sp
            )
            Spacer(modifier = Modifier.width(15.dp))
            Box(
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.dumbell),
                    contentDescription = "dumbbell",
                    tint = DarkPurple
                )
                Icon(
                    painter = painterResource(id = R.drawable.dumbell),
                    contentDescription = "dumbbell",
                    tint = Color.Black,
                    modifier = Modifier
                        .alpha(.1f)
                        .offset((-.5).dp, 2.dp)
                        .blur(.8.dp)
                )
            }
            Text(
                text = "Exercise Pts",
                fontFamily = FontFamily(Font(R.font.inter_regular)),
                fontSize = 14.sp,
                lineHeight = 17.sp
            )
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            StatUnit(
                value = totalCalories.toString(),
                type = "Cal"
            )
            StatUnit(
                value = "$dayNo/$totalDays",
                type = "Days"
            )
            StatUnit(
                value = healthScore.toString(),
                type = "Health Score"
            )
        }
        Spacer(modifier = Modifier.height(32.dp))
    }
}

@Composable
fun ScrollIndicator(
    color: Color
) {
    Canvas(
        modifier = Modifier
            .size(20.dp)
    ) {
        this.drawCircle(
            color = color,
            radius = 5.dp.toPx()
        )
    }
}

@Composable
fun SetGoalIndicator(
    onClick: () -> Unit
) {
    Box(
        contentAlignment = Alignment.CenterEnd,
        modifier = Modifier.fillMaxWidth()
    ) {
        IconButton(
            onClick = { onClick() },
            modifier = Modifier.padding(5.dp)
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = "Right Arrow",
                tint = MiddleOrange
            )
        }

        Text(
            text = "SET GOAL!",
            fontFamily = FontFamily(Font(R.font.inter_bold)),
            fontSize = 24.sp,
            lineHeight = 28.sp,
            modifier = Modifier.align(Alignment.Center)
        )
        Box(
            modifier = Modifier
                .size(260.dp)
                .align(Alignment.Center)
        ) {
            Canvas(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                this.drawCircle(
                    color = Color.Black,
                    style = Stroke(10.dp.toPx()),
                    radius = 113.dp.toPx(),
                    alpha = .9f,
                    blendMode = BlendMode.Softlight,
                    center = Offset(center.x + 1f, center.y + 4f)
                )
                this.drawCircle(
                    color = Color.Black,
                    style = Stroke(10.dp.toPx()),
                    radius = 90.dp.toPx(),
                    alpha = .9f,
                    blendMode = BlendMode.Overlay,
                    center = Offset(center.x + 1f, center.y + 4f)
                )
                this.drawCircle(
                    color = MiddleOrange,
                    style = Stroke(10.dp.toPx()),
                    radius = 113.dp.toPx(),
                    alpha = .5f
                )
//                this.drawCircle(
//                    color = MiddleOrange,
//                    radius = 5.dp.toPx(),
//                    alpha = .5f,
//                    center = Offset(center.x, center.y+(-113f))
//                )
                this.drawCircle(
                    color = DarkPurple,
                    style = Stroke(10.dp.toPx()),
                    radius = 90.dp.toPx(),
                    alpha = .5f
                )
            }
        }

    }
}

@Composable
fun SetGoal(
    totalCalories: Int,
    dayNo: Int,
    totalDays: Int,
    healthScore: Int,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        SetGoalIndicator(onClick)
        Stats(totalCalories, dayNo, totalDays, healthScore)
        Row {
            ScrollIndicator(color = DarkOrange)
            ScrollIndicator(color = LightGrey)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun StatUnitPreview() {
    StatUnit(value = (1500).toString(), type = "Cal")
}

@Preview(showBackground = true)
@Composable
private fun StatsPreview() {
    Stats(
        totalCalories = 1500,
        dayNo = 3,
        totalDays = 5,
        healthScore = 88
    )
}

@Preview(showBackground = true)
@Composable
private fun ScrollIndicatorPreview() {
    ScrollIndicator(color = DarkOrange)
}

@Preview(showBackground = true)
@Composable
private fun SetGoalIndicatorPreview() {
    SetGoalIndicator(onClick = {})
}

@Preview(showSystemUi = true)
@Composable
private fun SetGoalPreview() {
    SetGoal(
        totalCalories = 1500,
        dayNo = 3,
        totalDays = 5,
        healthScore = 88,
        onClick = {}
    )
}