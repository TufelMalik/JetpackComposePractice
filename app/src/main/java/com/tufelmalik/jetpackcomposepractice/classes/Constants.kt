package com.tufelmalik.jetpackcomposepractice.classes

import android.content.Context
import android.widget.Toast

object Constants {
    const val BASE_URL = "https://api.jsonbin.io/"
    private const val TWEETS_BIN_ID = "663e303cacd3cb34a845d014"
    private const val CATEGORY_BIN_ID = "663e3050e41b4d34e4f1a5eb"
    const val TWEETS_URL = "v3/b/$TWEETS_BIN_ID?meta=false"
    const val CATEGORY_URL = "v3/b/$TWEETS_BIN_ID?meta=false"


    fun returnTweetName(category: String): String {
        return "tweets[?(@.category==\"$category\")]"
    }
    fun showToast(context: Context, msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

}