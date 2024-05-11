package com.tufelmalik.jetpackcomposepractice.api

import com.tufelmalik.jetpackcomposepractice.classes.Constants.CATEGORY_URL
import com.tufelmalik.jetpackcomposepractice.classes.Constants.TWEETS_URL
import com.tufelmalik.jetpackcomposepractice.data.TweetModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface TweetsApi {

    @GET(TWEETS_URL)
    suspend fun getTweets(@Header("X-JSON-Path") category: String): Response<List<TweetModel>>

    @GET(CATEGORY_URL)
    @Headers("X-JSON-Path:tweets..category")
    suspend fun getCategoryList(): Response<List<String>>

}