package com.tufelmalik.jetpackcomposepractice.repository

import com.tufelmalik.jetpackcomposepractice.api.TweetsApi
import com.tufelmalik.jetpackcomposepractice.classes.Constants.returnTweetName
import com.tufelmalik.jetpackcomposepractice.data.TweetModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class TweetsRepository @Inject constructor(private val tweetsApi: TweetsApi) {

    private var _tweets = MutableStateFlow<List<TweetModel>>(emptyList())
    val tweets: StateFlow<List<TweetModel>>
        get() = _tweets

    private var _category = MutableStateFlow<List<String>>(emptyList())
    val category: StateFlow<List<String>>
        get() = _category


    suspend fun getTweetsList(category: String) {
        val response = tweetsApi.getTweets(returnTweetName(category))
        if (response.isSuccessful && response.body() != null) {
            _tweets.emit(response.body()!!)
        }
    }

    suspend fun getCategoryList() {
        val response = tweetsApi.getCategoryList()
        if (response.isSuccessful && response.body() != null) {
            _category.emit(response.body()!!)
        }
    }


}