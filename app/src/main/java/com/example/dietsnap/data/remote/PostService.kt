package com.example.dietsnap.data.remote

import com.example.dietsnap.data.remote.dto.FoodResponse
import com.example.dietsnap.data.remote.dto.HomeResponse
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json

interface PostService {

    suspend fun getPosts(): HomeResponse?

    suspend fun getFoodInfo(): FoodResponse?

    companion object{
        fun create(): PostService{
            return PostServiceImpl(
                client = HttpClient(CIO){
                    install(Logging){
                        level = LogLevel.ALL
                    }
                    install(ContentNegotiation){
                        json()
                    }

                }
            )
        }
    }

}