package com.hasan.lazygridcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.hasan.lazygridcompose.ui.theme.LazyGridComposeTheme
import kotlinx.coroutines.launch

@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyGridComposeTheme {
                val state = rememberLazyGridState(
                    initialFirstVisibleItemIndex = 99
                )
                val scope = rememberCoroutineScope()
                LazyVerticalGrid(columns = GridCells.Fixed(4), state = state, content = {
                    items(1000) { i ->
                        Box(
                            modifier = Modifier
                                .padding(8.dp)
                                .aspectRatio(1f)
                                .clip(RoundedCornerShape(5.dp))
                                .background(Color.Green)
                                .clickable {
                                    scope.launch {
                                        state.animateScrollToItem(99)
                                    }
                                }, contentAlignment = Alignment.Center
                        ) {
                            Text(text = "Item $i")
                        }
                    }
                })
            }
        }
    }
}
