package com.example.jcuiapp3.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jcuiapp3.R
import com.example.jcuiapp3.ui.theme.AppPurple


@Composable
fun HeaderRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(25.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = "$", fontSize = 24.sp, color = AppPurple)
                Text(
                    text = "6,890",
                    fontSize = 38.sp,
                    fontWeight = FontWeight.Bold,
                    color = AppPurple
                )
            }
            Text(text = "June Earning", fontSize = 18.sp, color = AppPurple)
        }
        Box(
            modifier = Modifier
                .padding(5.dp)
                .clip(RoundedCornerShape(20))
        ) {
            Image(
                painter = painterResource(id = R.drawable.user),
                contentDescription = "User",
                modifier = Modifier.size(50.dp)
            )
        }
    }
}
