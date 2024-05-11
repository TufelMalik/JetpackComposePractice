package com.tufelmalik.jetpackcomposepractice.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tufelmalik.jetpackcomposepractice.data.TweetModel
import com.tufelmalik.jetpackcomposepractice.repository.TweetsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TweetsViewModel @Inject constructor(
    private val tweetsRepository: TweetsRepository
) : ViewModel() {

    val tweets: StateFlow<List<TweetModel>> = tweetsRepository.tweets

    init {
        viewModelScope.launch {
            tweetsRepository.getTweetsList("Android")
        }
    }


    suspend fun getTweetsList(category: String) {
        tweetsRepository.getTweetsList(category)
    }

}