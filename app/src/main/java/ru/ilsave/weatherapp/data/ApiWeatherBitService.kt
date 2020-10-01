package ru.ilsave.weatherapp.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import ru.ilsave.weatherapp.data.network.response.CurrentWeatherResponse
import ru.ilsave.weatherapp.util.Constants.Companion.API_KEY


//https://api.weatherbit.io/v2.0/current?city=Nizny+Novgorod&lang=ru&key=39d5f89d11914467901e9526f07c79bd


interface ApiWeatherBitService {

    @GET("v2.0/current")
    suspend fun getCurrentWeatherApiService(
        @Query("city")  location: String,
        @Query("lang")  language: String = "en",
        @Query("key")  apikey: String = API_KEY
    ): Response<CurrentWeatherResponse>


}