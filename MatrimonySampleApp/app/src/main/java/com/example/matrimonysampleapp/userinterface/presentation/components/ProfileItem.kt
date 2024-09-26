package com.example.matrimonysampleapp.userinterface.presentation.components

import android.content.Context
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.matrimonysampleapp.model.Profile

@Composable
fun ProfileItem(
    profile: Profile,
    modifier: Modifier = Modifier,
    context: Context = LocalContext.current,
    cornerRadius: Dp = 10.dp,
    cutCornerSize: Dp = 30.dp,
) {
    CardView(
        shape = RoundedCornerShape(8.dp),
        backgroundColor = MaterialTheme.colorScheme.primary,
        modifier = modifier.width(200.dp).height(300.dp),
        profile = profile
    ) {}
}

