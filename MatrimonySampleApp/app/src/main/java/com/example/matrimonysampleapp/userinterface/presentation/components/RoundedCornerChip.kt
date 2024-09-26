package com.example.matrimonysampleapp.userinterface.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun RoundedCornerChip(
    content: String = "5 new",
    contentColor: Color = Color.White,
    borderColor: Color = Color.White,
) {
    val shape = RoundedCornerShape(60)
    Card(
        modifier = Modifier.border(shape = shape, width = 1.dp, color = borderColor),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent,
        ),
        shape = shape,
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier,
        ) {
            Text(
                text = content,
                color = contentColor,
                fontWeight = FontWeight.W800,
                modifier = Modifier.padding(horizontal = 10.dp),
            )
        }
    }
}