package com.example.jcuiapp3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.FloatingActionButtonElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jcuiapp3.data.MockData
import com.example.jcuiapp3.ui.screen.EarningSpending
import com.example.jcuiapp3.ui.screen.HeaderFilter
import com.example.jcuiapp3.ui.screen.HeaderRow
import com.example.jcuiapp3.ui.screen.MonthlyStats
import com.example.jcuiapp3.ui.theme.AppGray
import com.example.jcuiapp3.ui.theme.AppGreen
import com.example.jcuiapp3.ui.theme.AppGreenDark
import com.example.jcuiapp3.ui.theme.AppPurple
import com.example.jcuiapp3.ui.theme.AppRed
import com.example.jcuiapp3.ui.theme.AppRedDark
import com.example.jcuiapp3.ui.theme.AppSilver
import com.example.jcuiapp3.ui.theme.AppSilverAlpha
import com.example.jcuiapp3.ui.theme.JCUIApp3Theme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JCUIApp3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainView()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainView() {
    val filters = listOf("Week", "Month", "Year")
    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxWidth()) {
            HeaderRow()
            HeaderFilter(filters)
            MonthlyStats()
            EarningSpending()
            val lazyListState = rememberLazyListState()
            var showFAB by remember { mutableStateOf(false) }
            if (lazyListState.isScrollInProgress) {
                showFAB = lazyListState.firstVisibleItemIndex > 2
            }
            val coroutineScope = rememberCoroutineScope()
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(25.dp, 5.dp)
            ) {
                Text(text = "Week Transaction", fontSize = 12.sp, color = AppPurple)
            }
            Scaffold(floatingActionButton = {
                if (showFAB) {
                    FloatingActionButton(
                        onClick = {
                            coroutineScope.launch {
                                lazyListState.animateScrollToItem(0)
                            }
                        },
                        containerColor = AppSilverAlpha,
                        elevation = FloatingActionButtonDefaults.elevation(0.dp, 0.dp)
                    ) {
                        Icon(imageVector = Icons.Default.KeyboardArrowUp, contentDescription = "Up")
                    }
                }
            }) {
                Spacer(modifier = Modifier.padding(it))
                LazyColumn(state = lazyListState) {
                    items(100) {
                        val index = it % MockData.getDataList().size
                        val item = MockData.get(index)
                        Row(
                            modifier = Modifier
                                .padding(30.dp, 10.dp)
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(60.dp)
                                    .clip(RoundedCornerShape(25.dp))
                                    .background(if (item.price >= 0) AppGreen else AppRed),
                                contentAlignment = Alignment.Center
                            ) {
                                if (item.price >= 0) {
                                    Icon(
                                        imageVector = Icons.Default.KeyboardArrowUp,
                                        contentDescription = "Up"
                                    )
                                } else Icon(
                                    imageVector = Icons.Default.KeyboardArrowDown,
                                    contentDescription = "Down"
                                )
                            }
                            Column(
                                Modifier
                                    .padding(10.dp)
                                    .weight(1f)
                            )
                            {
                                Text(text = item.title, fontSize = 14.sp, color = Color.Black)
                                Text(text = item.date, fontSize = 10.sp, color = AppGray)
                            }
                            Text(
                                text = if (item.price >= 0) "+${item.price}$" else "${item.price}$",
                                color = if (item.price >= 0) AppGreenDark else AppRedDark,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JCUIApp3Theme {
        MainView()
    }
}