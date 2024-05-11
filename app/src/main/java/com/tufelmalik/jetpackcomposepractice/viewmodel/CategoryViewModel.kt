package com.tufelmalik.jetpackcomposepractice.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tufelmalik.jetpackcomposepractice.repository.TweetsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val tweetsRepository: TweetsRepository
) : ViewModel() {
    val tweetsCategory: StateFlow<List<String>> = tweetsRepository.category

    init {
        viewModelScope.launch {
            tweetsRepository.getCategoryList()
        }
    }

    suspend fun getCategoryList() {
        tweetsRepository.getCategoryList()
    }

}