package com.example.jetpackmvvm.data.remote.dto

import com.example.jetpackmvvm.domain.models.Coin
import com.google.gson.annotations.SerializedName

//data came from api
data class CoinDto(
    val id: String,
    @SerializedName("is_active")
    val is_active: Boolean,
    @SerializedName("is_new")
    val is_new: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)

//convert to Coin
fun CoinDto.toCoin(): Coin {
    return  Coin(
        id=id,
        is_active=is_active,
        name=name,
        rank=rank,
        symbol=symbol
    )
}