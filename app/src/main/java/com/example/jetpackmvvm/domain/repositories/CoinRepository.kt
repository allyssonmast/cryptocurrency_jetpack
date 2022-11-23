package com.example.jetpackmvvm.domain.repositories

import com.example.jetpackmvvm.data.remote.dto.CoinDetailDto
import com.example.jetpackmvvm.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins():List<CoinDto>
    suspend fun getCoinById(coinId:String):CoinDetailDto
}