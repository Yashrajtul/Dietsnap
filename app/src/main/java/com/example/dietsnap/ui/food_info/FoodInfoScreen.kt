package com.example.dietsnap.ui.food_info

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.dietsnap.R
import com.example.dietsnap.data.remote.dto.FoodResponse
import com.example.dietsnap.generic_facts
import com.example.dietsnap.nutritionScaledInfo
import com.example.dietsnap.similarItems
import com.example.dietsnap.ui.food_info.components.Description
import com.example.dietsnap.ui.food_info.components.Facts
import com.example.dietsnap.ui.food_info.components.MacroNutrients
import com.example.dietsnap.ui.food_info.components.FoodImage
import com.example.dietsnap.ui.food_info.components.SimilarItems

data class ImageFood(
    val name: String,
    val image: Int
)


@Composable
fun FoodInfoScreen(
    name: String,
    rating: Int,
    description: String,
    facts: List<String>,
    similarItems: List<FoodResponse.Data.SimilarItems>,
    nutritionScaledInfo: List<FoodResponse.Data.NutritionScaledInfo>,
    noOfServings: Float,
    onClick: () -> Unit
) {
    val images = listOf(
        ImageFood("Chicken Biryani", R.drawable.chicken_biryani),
        ImageFood("Veg Biryani", R.drawable.veg_biryani),
        ImageFood("Paneer Biryani", R.drawable.paneer_biryani),
        ImageFood("Mutton Biryani", R.drawable.mutton_biryani),
        ImageFood("Fried Chicken", R.drawable.chicken_fried),
        ImageFood("Pulav", R.drawable.pulav)
    )
    val items: List<ImageFood> = similarItems.map {food->
        images.first{food.name == it.name}
    }
    Column (
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ){
        FoodImage(name = name, image = images.first { it.name == name }.image, rating = rating, onClick = onClick)
        Description(description)
        MacroNutrients(noOfServings, nutritionScaledInfo)
        Facts(facts = facts)
        SimilarItems(imageFood = items)
    }
}

@Preview(showSystemUi = true)
@Composable
private fun FoodInfoScreenPreview() {
    FoodInfoScreen(
        name = "Chicken Biryani",
        rating = 71,
        description = "Fried chicken is a dish consisting of chicken pieces usually from broiler chickens which have been floured or battered and then pan-fried, deep fried, or pressure fried.",
        facts = generic_facts,
        similarItems = similarItems,
        nutritionScaledInfo = nutritionScaledInfo,
        noOfServings = 4f,
        onClick = {}
    )
}