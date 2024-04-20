package com.example.dietsnap.ui.food_info.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dietsnap.R
import com.example.dietsnap.ui.food_info.ImageFood

@Composable
fun SimilarItemUnit(
    title: String,
    image: Int
) {
    Card(
        modifier = Modifier
            .size(157.dp, 113.dp)
            .padding(end = 6.dp)
    ) {
        Box(
            contentAlignment = Alignment.BottomCenter
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = "",
                contentScale = ContentScale.Crop
            )
            Box(modifier = Modifier.padding(5.dp)){
                Text(
                    text = "Chicken Tandoor",
                    fontFamily = FontFamily(Font(R.font.inter_extrabold)),
                    color = Color.Black,
                    fontSize = 16.sp,
                    lineHeight = 19.sp,
                    modifier = Modifier
                        .alpha(.20f)
                        .offset(2.dp, 4.dp)
                        .blur(.20.dp)
                )
                Text(
                    text = title,
                    fontFamily = FontFamily(Font(R.font.inter_extrabold)),
                    color = Color.White,
                    fontSize = 16.sp,
                    lineHeight = 19.sp,
                )

            }
        }
    }
}

@Composable
fun SimilarItems(
    imageFood: List<ImageFood>
) {
    Column {
        SubHeading(title = "Similar Items")
        LazyRow (
            contentPadding = PaddingValues(16.dp)
        ){
            items(imageFood){food->
                SimilarItemUnit(title = food.name, image = food.image)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SimilarItemUnitPreview() {
    SimilarItemUnit(title = "Chicken Tandoor", image = R.drawable.chicken_tandoor)
}

@Preview(showSystemUi = true)
@Composable
private fun SimilarItemsPreview() {
    SimilarItems(
        imageFood = listOf(
            ImageFood("Chicken Biryani", R.drawable.chicken_biryani),
            ImageFood("Veg Biryani", R.drawable.veg_biryani),
            ImageFood("Paneer Biryani", R.drawable.paneer_biryani),
            ImageFood("Mutton Biryani", R.drawable.mutton_biryani),
            ImageFood("Fried Chicken", R.drawable.chicken_fried),
            ImageFood("Pulav", R.drawable.pulav)
        )
    )
}