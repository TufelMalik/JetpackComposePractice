package com.tufelmalik.jetpackcomposepractice.di

import com.tufelmalik.jetpackcomposepractice.api.TweetsApi
import com.tufelmalik.jetpackcomposepractice.classes.Constants.BASE_URL
import com.tufelmalik.jetpackcomposepractice.classes.LoggingInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun providesLoggingInterceptor(): LoggingInterceptor {
        return LoggingInterceptor()
    }

    @Singleton
    @Provides
    fun providesOkHttpClient(loggingInterceptor: LoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }


    @Singleton
    @Provides
    fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(
                OkHttpClient.Builder()
                    .connectTimeout(30, TimeUnit.SECONDS) // Adjust timeout duration as needed
                    .readTimeout(30, TimeUnit.SECONDS) // Adjust timeout duration as needed
                    .build()
            )
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesTweetsApi(retrofit: Retrofit): TweetsApi {
        return retrofit.create(TweetsApi::class.java)
    }
}