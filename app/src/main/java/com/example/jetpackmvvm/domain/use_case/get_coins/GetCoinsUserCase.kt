package com.example.jetpackmvvm.domain.use_case.get_coins

import com.example.jetpackmvvm.common.Resource
import com.example.jetpackmvvm.data.remote.dto.toCoin
import com.example.jetpackmvvm.domain.models.Coin
import com.example.jetpackmvvm.domain.repositories.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCoinsUserCase @Inject constructor(
   private val repository :CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins=repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        }catch (e: HttpException){
            emit(Resource.Error(message ="An unexpected error occured"))
        }catch (e:IOException){
            emit(Resource.Error(message = "Check internet conection"))
        }
    }
}