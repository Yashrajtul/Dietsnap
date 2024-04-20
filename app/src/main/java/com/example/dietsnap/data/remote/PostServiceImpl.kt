package com.example.dietsnap.data.remote

import com.example.dietsnap.data.remote.dto.FoodResponse
import com.example.dietsnap.data.remote.dto.HomeResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.request.get
import io.ktor.client.request.url
import java.lang.Exception

class PostServiceImpl(
    private val client: HttpClient
) : PostService {
    override suspend fun getPosts(): HomeResponse? {
        return try{
            client.get { url(HttpRoutes.HOME) }.body<HomeResponse>()
        }catch (e: RedirectResponseException) {
            println("Error: ${e.response.status.description}")
            HomeResponse()
        } catch (e: ClientRequestException) {
            println("Error: ${e.response.status.description}")
            HomeResponse()
        } catch (e: ServerResponseException) {
            println("Error: ${e.response.status.description}")
            HomeResponse()
        } catch (e: Exception) {
            println("Error: ${e.message}")
            HomeResponse()
        }
    }

    override suspend fun getFoodInfo(): FoodResponse? {
        return try{
            client.get { url(HttpRoutes.FOOD_INFO) }.body<FoodResponse>()
        }catch (e: RedirectResponseException) {
            println("Error: ${e.response.status.description}")
            FoodResponse()
        } catch (e: ClientRequestException) {
            println("Error: ${e.response.status.description}")
            FoodResponse()
        } catch (e: ServerResponseException) {
            println("Error: ${e.response.status.description}")
            FoodResponse()
        } catch (e: Exception) {
            println("Error: ${e.message}")
            FoodResponse()
        }
    }
}