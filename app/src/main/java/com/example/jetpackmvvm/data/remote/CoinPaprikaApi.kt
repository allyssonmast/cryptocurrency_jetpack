package com.example.jetpackmvvm.data.remote

import com.example.jetpackmvvm.data.remote.dto.CoinDetailDto
import com.example.jetpackmvvm.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {
    @GET("/v1/coins")
    suspend fun getCoins():List<CoinDto>

    @GET("/v1/coins/{coinI}")
    suspend fun getCoinById(@Path("coinId")coinId:String) :CoinDetailDto
}