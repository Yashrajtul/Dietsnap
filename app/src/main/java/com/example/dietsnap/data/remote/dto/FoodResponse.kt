package com.example.dietsnap.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class FoodResponse(
    val success: Boolean = false,
    val data: Data = Data(),
    val message: String = ""
){
    @Serializable
    data class Data(
        val _id : String = "",
        val api_name: List<String> = emptyList(),
        val badge_indicator: String = "",
        val credits_url: String = "",
        val cuisine: String = "",
        val description: String = "",
        val generic_facts: List<String> = emptyList(),
        val health_rating: Float = 0f,
        val image: String = "",
        val image_url: String = "",
        val ingredients: List<Ingredients> = emptyList(),
        val itemtype: String = "",
        val name: String = "",
        val no_of_servings: Float = 0f,
        val nutrition_facts: String = "",
        val nutrition_info: String = "",
        val nutrition_info_scaled: List<NutritionScaledInfo> = emptyList(),
        val serving_sizes: List<ServingSizes> = emptyList(),
        val similar_items: List<SimilarItems> = emptyList(),
        val type: String = "",
        val default_unit_serving: String = ""
    ){
        @Serializable
        data class Ingredients(
            val ingid: String = "",
            val name: String = "",
            val value: Float = 0f
        )
        @Serializable
        data class NutritionScaledInfo(
            val name: String = "",
            val value: Float = 0f,
            val units: String
        )
        @Serializable
        data class ServingSizes(
            val units: String = "",
            val name: String = "",
            val value: Float = 0f
        )
        @Serializable
        data class SimilarItems(
            val _id: String = "",
            val name: String = "",
            val image: String = ""
        )
    }
}
