package com.example.dietsnap.ui.home.goal

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dietsnap.R
import com.example.dietsnap.ui.theme.LightOrange
import com.example.dietsnap.ui.theme.MediumGrey
import com.example.dietsnap.ui.theme.ProgressBarOrange

@Composable
fun CircularProgressBar(
    modifier: Modifier = Modifier,
    percentage: Float,
    number: Int,
    fontSize: TextUnit = 11.sp,
    radius: Dp = 21.dp,
    color: Color,
    strikeWidth: Dp = 8.dp,
    animDuration: Int = 1000,
    animDelay: Int = 0
) {
    var animationPlayed by remember {
        mutableStateOf(false)
    }
    val curPercentage = animateFloatAsState(
        targetValue = if (animationPlayed) percentage else 0f,
        animationSpec = tween(
            durationMillis = animDuration,
            delayMillis = animDelay
        )
    )
    LaunchedEffect(key1 = true) {
        animationPlayed = true
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(radius * 2f)
    ) {
        Canvas(modifier = Modifier.size(radius * 2f)) {
            drawArc(
                color = color,
                0f,
                -360 * curPercentage.value,
                useCenter = false,
                style = Stroke(strikeWidth.toPx(), cap = StrokeCap.Round)
            )
        }
        Text(
            text = (curPercentage.value * number).toInt().toString() + " %",
            color = Color.Black,
            fontSize = fontSize,
            fontFamily = FontFamily(Font(R.font.inter_regular))
        )
    }
}

@Composable
fun GoalItem(
    currentPlanName: String,
    percentage: Float,
    ) {
    Card(
//        colors = CardDefaults.cardColors(DimGrey),
        shape = RoundedCornerShape(14.dp),
        modifier = Modifier
            .padding(horizontal = 14.dp)
            .height(80.dp)
            .fillMaxWidth()

    ) {
        Row(
            Modifier.padding(vertical = 13.dp, horizontal = 9.dp)
        ) {
            Surface(
                shape = RoundedCornerShape(14.dp),
                modifier = Modifier
//                .padding(13.dp)
                    .size(54.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.bodybuilder),
                    contentDescription = ""
                )
            }
            Spacer(modifier = Modifier.width(13.dp))
            Column {
                Text(
                    text = currentPlanName,
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.inter_regular)),
                        fontSize = 17.sp
                    )
                )
                Text(
                    text = "Current Major Goal",
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.inter_regular)),
                        fontSize = 15.sp,
                        color = MediumGrey
                    )
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            CircularProgressBar(
                percentage = percentage,
                number = 100,
                color = ProgressBarOrange,
                modifier = Modifier.padding(5.dp)
            )
        }
    }
}


@Composable
fun Goals(
    currentPlanName: String,
    percentage: Float
) {
    Column {
        Text(
            text = "Your Goals",
            style = TextStyle(
                fontFamily = FontFamily(Font(R.font.inter_medium)),
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp,
                lineHeight = 21.sp
            ),
            modifier = Modifier.padding(start = 16.dp, top = 18.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        GoalItem(currentPlanName, percentage)
    }
}

@Preview(showBackground = true)
@Composable
private fun CircularProgressBarPreview() {
    CircularProgressBar(percentage = 0.8f, number = 100, color = LightOrange)
}

@Preview
@Composable
private fun GoalItemPreview() {
    GoalItem("Keto Weight loss plan", .8f)
}

@Preview(showBackground = true)
@Composable
private fun GoalsPrev() {
    Goals("Keto Weight loss plan", .8f)
}