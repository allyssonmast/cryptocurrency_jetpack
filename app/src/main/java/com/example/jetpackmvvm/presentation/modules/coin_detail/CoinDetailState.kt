package com.example.jetpackmvvm.presentation.modules.coin_detail

import com.example.jetpackmvvm.domain.models.Coin
import com.example.jetpackmvvm.domain.models.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean=false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
