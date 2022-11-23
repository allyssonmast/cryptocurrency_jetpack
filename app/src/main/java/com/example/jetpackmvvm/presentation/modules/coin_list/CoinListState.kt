package com.example.jetpackmvvm.presentation.modules.coin_list

import com.example.jetpackmvvm.domain.models.Coin

data class CoinListState(
    val isLoading: Boolean=false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
