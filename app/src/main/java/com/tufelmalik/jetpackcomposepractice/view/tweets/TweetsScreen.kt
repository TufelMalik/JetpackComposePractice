package com.tufelmalik.jetpackcomposepractice.view.tweets

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.tufelmalik.jetpackcomposepractice.data.TweetModel
import com.tufelmalik.jetpackcomposepractice.viewmodel.TweetsViewModel
import java.net.SocketTimeoutException

@Composable
fun TweetsScreen(category: String) {
    val viewModel: TweetsViewModel = viewModel()
    val tweetsList: State<List<TweetModel>> = viewModel.tweets.collectAsState()

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
        modifier = Modifier.padding(top = 20.dp, bottom = 20.dp),
        verticalArrangement = Arrangement.SpaceAround
    ) {
        try {
            items(tweetsList.value.distinct()) {
                Log.d("TweetsScreen", "Data : $it")
                TweetsItems(tweets = it)
            }
        } catch (e: SocketTimeoutException) {
            Log.d("TweetsScreen", "Error in Socket : ${e.message}")
        } catch (e: Exception) {
            Log.d("TweetsScreen", "Error in Exception : ${e.message}")
        }
    }
}

@Composable
fun TweetsItems(tweets: TweetModel) {
    Card(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth(),
        border = BorderStroke(1.dp, Color(0xFFCCCCCC)),
        content = {
            Text(
                text = tweets.text,
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.bodyMedium
            )

        }
    )
}