package com.example.jetpackmvvm.di

import com.example.jetpackmvvm.common.Constants.BASE_URL
import com.example.jetpackmvvm.data.remote.CoinPaprikaApi
import com.example.jetpackmvvm.data.repository.CoinRepositoryImp
import com.example.jetpackmvvm.domain.repositories.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

//put dependencies you want to inject(its interfaces)

@Module
@InstallIn(SingletonComponent::class)//during all life off aplication
object AppModule {
    @Provides
    @Singleton//just one instance
    fun providePaprikaApi():CoinPaprikaApi{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton//just one instance
    fun provideCoinRepository(api: CoinPaprikaApi):CoinRepository{
        return CoinRepositoryImp(api)
    }
}