package com.example.jetpackmvvm.domain.models

import com.example.jetpackmvvm.data.remote.dto.TeamMember

data class CoinDetail (
    val coinId:String,
    var name: String,
    val description:String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    var team: List<TeamMember>
    )