package com.example.jetpackmvvm.data.repository

import com.example.jetpackmvvm.data.remote.CoinPaprikaApi
import com.example.jetpackmvvm.data.remote.dto.CoinDetailDto
import com.example.jetpackmvvm.data.remote.dto.CoinDto
import com.example.jetpackmvvm.domain.repositories.CoinRepository
import javax.inject.Inject

class CoinRepositoryImp @Inject constructor(
    private val api: CoinPaprikaApi
):CoinRepository{
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }

}