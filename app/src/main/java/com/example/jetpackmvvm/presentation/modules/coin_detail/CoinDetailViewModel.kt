package com.example.jetpackmvvm.presentation.modules.coin_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.jetpackmvvm.common.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackmvvm.common.Constants
import com.example.jetpackmvvm.domain.use_case.get_coin.GetCoinUseCase
import com.example.jetpackmvvm.presentation.modules.coin_list.CoinListState
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase,
    savedStateHandle: SavedStateHandle
):ViewModel(){
    private val _state= mutableStateOf(CoinDetailState())
    val state: State<CoinDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let { coind->getCoins(coind) }
    }

    private fun getCoins(coinId:String){
        getCoinUseCase(coinId).onEach { resource ->
            when(resource){
                is Resource.Success ->{
                    _state.value= CoinDetailState(coins = resource.data)
                }
                is Resource.Error ->{
                    _state.value= CoinDetailState(error = resource.message?:"An error occured")
                }
                is Resource.Loading ->{
                    _state.value = CoinDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}