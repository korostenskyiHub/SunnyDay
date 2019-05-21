package com.korostenskyi.sunnyday.data.network.api

import com.korostenskyi.sunnyday.data.entity.SunriseSunsetResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiService {

    private val BASE_URL = "https://api.sunrise-sunset.org/"

    private val retrofit: Retrofit
    private val client: ApiClient

    init {
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        client = retrofit.create(ApiClient::class.java)
    }

    fun fetchDayInfoByCoordinates(latitude: Double, longitude: Double): Deferred<Response<SunriseSunsetResponse>> {
        return client.fetchDayInfoByCoordinates(latitude, longitude)
    }
}