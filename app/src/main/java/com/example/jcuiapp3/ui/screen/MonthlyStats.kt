package com.example.jcuiapp3.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jcuiapp3.ui.theme.AppPurple
import com.example.jcuiapp3.ui.theme.AppSilverAlpha


@Composable
fun MonthlyStats() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(25.dp)
            .height(100.dp)
            .clip(RoundedCornerShape(25.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(AppPurple)
                .padding(15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box {
                CircularProgressIndicator(
                    progress = 1f,
                    color = AppSilverAlpha,
                    modifier = Modifier.size(60.dp),
                    strokeWidth = 6.dp
                )
                CircularProgressIndicator(
                    progress = 0.20f,
                    color = Color.White,
                    modifier = Modifier.size(60.dp),
                    strokeWidth = 6.dp
                )
                Text(
                    text = "20%",
                    color = Color.White,
                    fontSize = 15.sp,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            Spacer(modifier = Modifier.width(15.dp))
            Column {
                Text(
                    text = "Monthly Stats",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(text = "+20 Better Performance", color = Color.White, fontSize = 12.sp)
            }
        }
    }
}
