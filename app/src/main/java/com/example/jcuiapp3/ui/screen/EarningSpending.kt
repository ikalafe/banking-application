package com.example.jcuiapp3.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jcuiapp3.ui.theme.AppGray
import com.example.jcuiapp3.ui.theme.AppGreen
import com.example.jcuiapp3.ui.theme.AppPurple
import com.example.jcuiapp3.ui.theme.AppRed


@Composable
fun EarningSpending() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(25.dp, 5.dp)
    ) {

        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(35.dp))
                        .padding(5.dp)
                        .background(AppGreen)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(30.dp)
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "Earning", color = AppGray, fontSize = 12.sp)
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(
                            text = "$58,560",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            color = AppPurple
                        )
                    }
                }
            }
            item {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(35.dp))
                        .padding(5.dp)
                        .background(AppRed)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(30.dp)
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "Spending", color = AppGray, fontSize = 12.sp)
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(
                            text = "$20,000",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            color = AppPurple
                        )
                    }
                }
            }
        }
    }
}
