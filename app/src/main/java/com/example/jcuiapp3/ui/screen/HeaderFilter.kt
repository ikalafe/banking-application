package com.example.jcuiapp3.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.jcuiapp3.ui.theme.AppSilver


@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun HeaderFilter(filters: List<String>) {
    var selectedFilter by remember { mutableStateOf(0) }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(25.dp, 0.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(
                AppSilver
            )
    ) {
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            items(filters.size) {
                Card(
                    onClick = { selectedFilter = it },
                    modifier = Modifier
                        .width(100.dp)
                        .background(if (selectedFilter == it) Color.White else Color.Transparent)
                        .clip(shape = RoundedCornerShape(20.dp)),
                    shape = RoundedCornerShape(20.dp),
                ) {
                    Text(
                        text = filters[it],
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(15.dp)
                            .fillMaxWidth()
                    )
                }
            }
        }
    }
}