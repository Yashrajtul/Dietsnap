package com.example.dietsnap.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class HomeResponse(
    val success: Boolean = false,
    val data: Data = Data(),
    val message: String = ""
) {
    @Serializable
    data class Data(
        val date: String = "2024-03-29T19:30:03.283Z",
        val day_progress: Progress = Progress(),
        val day_no: Int = 0,
        val total_days: Int = 0,
        val total_calories: Int = 0,
        val health_score: Int = 0,
        val current_plan_name: String = ""
    ) {
        @Serializable
        data class Progress(
            val food: Int = 0,
            val exercise: Int = 0
        )
    }
}
