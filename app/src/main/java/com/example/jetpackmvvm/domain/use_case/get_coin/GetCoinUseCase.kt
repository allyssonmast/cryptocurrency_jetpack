package com.example.jetpackmvvm.domain.use_case.get_coin

import com.example.jetpackmvvm.common.Resource
import com.example.jetpackmvvm.data.remote.dto.toCoin
import com.example.jetpackmvvm.data.remote.dto.toCoinDetail
import com.example.jetpackmvvm.domain.models.Coin
import com.example.jetpackmvvm.domain.models.CoinDetail
import com.example.jetpackmvvm.domain.repositories.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository :CoinRepository
) {
    operator fun invoke(coinId:String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin=repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coin))
        }catch (e: HttpException){
            emit(Resource.Error<CoinDetail>(message ="An unexpected error occured"))
        }catch (e:IOException){
            emit(Resource.Error<CoinDetail>(message = "Check internet conection"))
        }
    }
}