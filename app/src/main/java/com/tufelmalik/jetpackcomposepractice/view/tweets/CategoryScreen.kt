package com.tufelmalik.jetpackcomposepractice.view.tweets

import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.tufelmalik.jetpackcomposepractice.viewmodel.CategoryViewModel
import java.net.SocketTimeoutException

@Preview
@Composable
fun CategoryScreen() {
    val categoryViewModel: CategoryViewModel = viewModel()
    val categories: State<List<String>> = categoryViewModel.tweetsCategory.collectAsState()

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.SpaceAround
    ) {
        try{
            items(categories.value.distinct()) {
                Log.d("CategoryScreen","Data : $it")
                CategoryItems(category = it)
            }
        }catch (e : SocketTimeoutException){
            Log.d("CategoryScreen","Error in Socket : ${e.message}")
        }catch (e : Exception){
            Log.d("CategoryScreen","Error in Exception : ${e.message}")
        }

    }
}

@Composable
fun CategoryItems(category: String) {
    Box(
        modifier = Modifier
            .padding(4.dp)
            .size(165.dp)
            .clip(RoundedCornerShape(7.dp))
            .border(1.dp, Color(0xFFCCCCCC)),
        contentAlignment = Alignment.BottomCenter,

    ) {
        Text(
            text = category,
            fontSize = 19.sp,
            color = Color.Black,
            modifier = Modifier.padding(
                0.dp, 20.dp
            ),
            style = MaterialTheme.typography.bodyLarge
        )
    }

}