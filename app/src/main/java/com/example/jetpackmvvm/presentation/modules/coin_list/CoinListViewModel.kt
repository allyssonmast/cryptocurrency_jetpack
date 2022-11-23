package com.example.jetpackmvvm.presentation.modules.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.jetpackmvvm.common.Resource
import com.example.jetpackmvvm.domain.use_case.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
):ViewModel(){
    private val _state= mutableStateOf(CoinListState())
    val state: State<CoinListState> = _state

    init {
        getCoins()
    }

    private fun getCoins(){
        getCoinsUseCase().onEach { resource ->
            when(resource){
                is Resource.Success ->{
                    _state.value= CoinListState(coins = resource.data?: emptyList())
                }
                is Resource.Error ->{
                    _state.value= CoinListState(error = resource.message?:"An error occured")
                }
                is Resource.Loading ->{
                    _state.value = CoinListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}