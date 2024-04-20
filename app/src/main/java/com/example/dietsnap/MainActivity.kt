package com.example.dietsnap

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dietsnap.data.remote.PostService
import com.example.dietsnap.data.remote.dto.FoodResponse
import com.example.dietsnap.data.remote.dto.HomeResponse
import com.example.dietsnap.ui.food_info.FoodInfoScreen
import com.example.dietsnap.ui.home.Home
import com.example.dietsnap.ui.theme.DietsnapTheme

class MainActivity : ComponentActivity() {

    private val client = PostService.create()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
//        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            val home = produceState<HomeResponse>(
                initialValue = HomeResponse(),
                producer = {
                    value = client.getPosts()!!
                }
            )
            val foodInfo = produceState<FoodResponse>(
                initialValue = FoodResponse()
            ) {
                value = client.getFoodInfo()!!
            }

            DietsnapTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
                ) {
                    App(
                        homeData = home.value.data,
                        foodInfoData = foodInfo.value.data
                    )

                }
            }
        }
    }
}

//enum class Page{
//    HOME, FOOD_INFO
//}


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun App(
//    modifier: Modifier = Modifier,
    homeData: HomeResponse.Data? = null,
    foodInfoData: FoodResponse.Data? = null,
) {
    if (homeData != null && homeData.current_plan_name != "") {
        Home(
            currentPlanName = homeData.current_plan_name,
            totalCalories = homeData.total_calories,
            dayNo = homeData.day_no,
            totalDays = homeData.total_days,
            healthScore = homeData.health_score,
            date = homeData.date,
            onClick = {}
        )
    } else {
        Home(
            currentPlanName = "Keto 30 Day Challenge",
            totalCalories = 860,
            dayNo = 30,
            totalDays = 3,
            healthScore = 74,
            onClick = {}
        )
    }
//            if (foodInfoData != null && foodInfoData.name != "") {
//                FoodInfoScreen(
//                    name = foodInfoData.name,
//                    rating = foodInfoData.health_rating.toInt(),
//                    description = foodInfoData.description,
//                    facts = foodInfoData.generic_facts,
//                    similarItems = foodInfoData.similar_items,
//                    nutritionScaledInfo = foodInfoData.nutrition_info_scaled,
//                    noOfServings = foodInfoData.no_of_servings,
//                    onClick = {}
//                )
//            } else {
//                FoodInfoScreen(
//                    name = "Chicken Biryani",
//                    rating = 76,
//                    description = "Traditional Indian Rice Preparation with helf boiled fragrant basmati rice,aromatic Indian spices yogurt and chicken.",
//                    facts = generic_facts,
//                    similarItems = similarItems,
//                    nutritionScaledInfo = nutritionScaledInfo,
//                    noOfServings = 4f,
//                    onClick = {}
//                )
//            }
}

val generic_facts = listOf(
    "Chicken biryani is a popular Indian dish made with fragrant basmati rice, tender chicken, and a blend of aromatic spices.",
    "It is believed to have originated in the Indian subcontinent and is now enjoyed worldwide for its rich flavors and comforting taste.",
    "There are many regional variations of chicken biryani, with each region adding its own unique twist to the dish.",
    "Traditionally, chicken biryani is cooked in layers, with marinated chicken and partially cooked rice layered together and then slow-cooked to perfection.",
    "Chicken biryani is often served with accompaniments such as raita, a yogurt-based condiment, and salan, a spicy curry."
)

val similarItems = listOf(
    FoodResponse.Data.SimilarItems(_id = "", name = "Veg Biryani", image = ""),
    FoodResponse.Data.SimilarItems(_id = "", name = "Paneer Biryani", image = ""),
    FoodResponse.Data.SimilarItems(_id = "", name = "Mutton Biryani", image = "")
)

val nutritionScaledInfo = listOf(
    FoodResponse.Data.NutritionScaledInfo(name = "Calories", value = 196.13958411156767f, units = "kCal"),
    FoodResponse.Data.NutritionScaledInfo(name = "Protein", value = 8.004016934379283f, units = "gms"),
    FoodResponse.Data.NutritionScaledInfo(name = "Carbohydrates", value = 19.430579006350396f, units = "gms"),
    FoodResponse.Data.NutritionScaledInfo(name = "Total Fat", value = 9.373579877972858f, units = "gms"),
    FoodResponse.Data.NutritionScaledInfo(name = "Saturated Fat", value = 1.7389186900759561f, units = "gms"),
    FoodResponse.Data.NutritionScaledInfo(name = "Unsaturated Fat", value = 0f, units = "gms"),
    FoodResponse.Data.NutritionScaledInfo(name = "Trans Fat", value = 0.010784460216660442f, units = "gms"),
    FoodResponse.Data.NutritionScaledInfo(name = "Fiber", value = 1.1127132362096877f, units = "gms"),
    FoodResponse.Data.NutritionScaledInfo(name = "Sugar", value = 1.4311106960527955f, units = "gms"),
    FoodResponse.Data.NutritionScaledInfo(name = "Cholesterol", value = 59.5504918441041f, units = "mg"),
    FoodResponse.Data.NutritionScaledInfo(name = "Vitamin A", value = 0f, units = "IU"),
    FoodResponse.Data.NutritionScaledInfo(name = "Vitamin C", value = 3.0660689826920686f, units = "mg"),
    FoodResponse.Data.NutritionScaledInfo(name = "Sodium", value = 148.69488419872994f, units = "mg"),
    FoodResponse.Data.NutritionScaledInfo(name = "Vitamin D", value = 5.105217283028266f, units = "IU"),
    FoodResponse.Data.NutritionScaledInfo(name = "Vitamin B6", value = 0.15440144440293865f, units = "mg"),
    FoodResponse.Data.NutritionScaledInfo(name = "Vitamin E", value = 1.4444054289627692f, units = "mg"),
    FoodResponse.Data.NutritionScaledInfo(name = "Vitamin K", value = 4.646557091271323f, units = "mcg"),
    FoodResponse.Data.NutritionScaledInfo(name = "Calcium", value = 87.20514257253146f, units = "mg"),
    FoodResponse.Data.NutritionScaledInfo(name = "Iron", value = 1.727243182667165f, units = "mg"),
    FoodResponse.Data.NutritionScaledInfo(name = "Potassium", value = 126.98680114556097f, units = "mg"),
    FoodResponse.Data.NutritionScaledInfo(name = "Magnesium", value = 15.166728925414022f, units = "mg"),
    FoodResponse.Data.NutritionScaledInfo(name = "Zinc", value = 0.9237492217656583f, units = "mg"),
    FoodResponse.Data.NutritionScaledInfo(name = "Selenium", value = 10.38008965259619f, units = "mcg"),
    FoodResponse.Data.NutritionScaledInfo(name = "Copper", value = 0.08226086415141329f, units = "mg"),
)

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showSystemUi = true)
@Composable
fun AppPreview() {
    DietsnapTheme {
        App(
            homeData = HomeResponse.Data(),
            foodInfoData = FoodResponse.Data(
                name = "Chicken Biryani",
                health_rating = 71f,
                description = "Fried chicken is a dish consisting of chicken pieces usually from broiler chickens which have been floured or battered and then pan-fried, deep fried, or pressure fried.",
                generic_facts = generic_facts,
                similar_items = similarItems,
                nutrition_info_scaled = nutritionScaledInfo,
                no_of_servings = 4f
            )
        )
    }
}