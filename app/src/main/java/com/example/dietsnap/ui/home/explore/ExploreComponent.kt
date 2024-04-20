package com.example.dietsnap.ui.home.explore

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dietsnap.R
import com.example.dietsnap.ui.theme.DimGrey
import com.example.dietsnap.ui.theme.LightGrey

@Composable
fun ExploreItem(
    modifier: Modifier = Modifier,
    image: Painter,
    title: String,
    subTitle: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
//            .background(LightGrey)
            .padding(8.dp)
    ) {
        Surface(
            modifier = Modifier
                .padding(start = 11.dp, end = 17.dp)
                .size(60.dp, 95.dp)
        ) {
            Image(painter = image, contentDescription = "")
        }

        Column (
            modifier = Modifier.padding(end = 20.dp)
        ){
            Text(
                text = title,
                fontFamily = FontFamily(Font(R.font.inter_regular)),
                fontSize = 17.sp,
                lineHeight = 22.sp
            )
            Spacer(modifier = Modifier.height(7.dp))
            Text(
                text = subTitle,
                fontFamily = FontFamily(Font(R.font.inter_regular)),
                fontSize = 12.sp,
                lineHeight = 20.sp
            )
        }

    }
}

data class ExploreUnit(
    val title: String,
    val subTitle: String,
    val image: Painter
)
@Composable
fun Explore() {
    val items = listOf(
        ExploreUnit("Find Diets",
            "Find premade diets according to your cuisine",
            painterResource(id = R.drawable.find_diets)
        ),
        ExploreUnit("Find Nutritionist",
            "Get customized diets to achieve your health goal",
            painterResource(id = R.drawable.find_nutritionist))
    )
    Column {
        Text(
            text = "Explore",
            style = TextStyle(
                fontFamily = FontFamily(Font(R.font.inter_medium)),
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp,
                lineHeight = 21.sp
            ),
            modifier = Modifier.padding(start = 16.dp, top = 18.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        items.forEach{item->
            ExploreItem(image = item.image, title = item.title, subTitle = item.subTitle)
        }

    }
}


@Preview(showSystemUi = true)
@Composable
private fun ExploreItemPreview() {
    ExploreItem(
        image = painterResource(id = R.drawable.find_diets),
        title = "Find Diets",
        subTitle = "Find premade diets according to your cuisine"
    )
}

@Preview(showBackground = true)
@Composable
private fun ExplorePreview() {
    Explore()
}
