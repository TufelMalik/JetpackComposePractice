package com.tufelmalik.jetpackcomposepractice.classes

sealed class Results<out T> {
    data object Loading : Results<Nothing>()
    data class Success<out T>(val data: T) : Results<T>()
    data class Error<out T>(val errorMsg: String?) : Results<T>()
}
