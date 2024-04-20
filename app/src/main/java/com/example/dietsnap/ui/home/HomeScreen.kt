package com.example.dietsnap.ui.home

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsIgnoringVisibility
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dietsnap.R
import com.example.dietsnap.ui.home.appbar.AppBar
import com.example.dietsnap.ui.home.bottomnav.BottomNavigation
import com.example.dietsnap.ui.home.explore.Explore
import com.example.dietsnap.ui.home.goal.Goals
import com.example.dietsnap.ui.home.goal.SetGoal
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Date

@SuppressLint("SimpleDateFormat")
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Home(
    modifier: Modifier = Modifier,
    currentPlanName: String,
    totalCalories: Int,
    dayNo: Int,
    totalDays: Int,
    healthScore: Int,
    date: String = "2024-03-29T19:30:03.283Z",
    onClick: () -> Unit
) {
    var progress by rememberSaveable {
        mutableFloatStateOf(0f)
    }
    progress = if(totalDays != 0) dayNo/totalDays.toFloat() else 0f

    val curTime = System.currentTimeMillis()
    val dt = SimpleDateFormat("d").format(Date()).toInt()

    val todayDate = SimpleDateFormat("EEEE, d").format(Date())+when(dt%10){
        1->"st"
        2->"nd"
        3->"rd"
        else -> "th"
    } + SimpleDateFormat(" LLL").format(Date())

    val dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    val formattedDate = LocalDateTime.parse(date, dateFormatter)
    val d = DateTimeFormatter.ofPattern("d").format(formattedDate).toInt()
    val res = DateTimeFormatter.ofPattern("EEEE, d").format(formattedDate)+when(d%10){
        1->"st"
        2->"nd"
        3->"rd"
        else -> "th"
    } + DateTimeFormatter.ofPattern(" LLL").format(formattedDate)

    Scaffold(
        topBar = {
            AppBar()
        },
        bottomBar = {
            BottomNavigation()
        },
        modifier = modifier
//            .statusBarsPadding()
            .navigationBarsPadding()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(it)
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "Today",
                fontFamily = FontFamily(Font(R.font.inter_semibold)),
                fontSize = 18.sp,
                lineHeight = 28.sp
            )
            Text(
//                text = "Thursday, 22nd Oct",
//                text = res,
                text = todayDate,
                fontFamily = FontFamily(Font(R.font.inter_regular)),
                fontSize = 15.sp,
                lineHeight = 20.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
            SetGoal(totalCalories, dayNo, totalDays, healthScore, onClick)
            Goals(currentPlanName, progress)
            Explore()
        }
    }
}

@Composable
fun HomeScreen(
    currentPlanName: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AppBar()
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Today",
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.inter_semibold)),
                    fontSize = 18.sp,
                    lineHeight = 28.sp
                )
            )
            Text(
                text = "Thursday, 22nd Oct",
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.inter_regular)),
                    fontSize = 15.sp,
                    lineHeight = 20.sp
                )
            )
        }
        Goals(currentPlanName, .8f)
        Explore()
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Preview(showSystemUi = true)
@Composable
private fun HomePrev() {
    Home(
        currentPlanName = "Keto Weight loss plan",
        totalCalories = 1500,
        dayNo = 3,
        totalDays = 5,
        healthScore = 88,
        date = "2024-03-29T19:30:03.283Z",
        onClick = {}
    )
}

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen(currentPlanName = "Keto Weight loss plan")
}