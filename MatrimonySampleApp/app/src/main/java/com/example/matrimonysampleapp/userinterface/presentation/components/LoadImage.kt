package com.example.matrimonysampleapp.userinterface.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import coil.compose.rememberImagePainter
import com.example.matrimonysampleapp.R

@Composable
fun LoadImage(url: String) {
    val painter = rememberImagePainter(
        data = url,
        builder = {
            error(R.drawable.error)
            placeholder(R.drawable.placeholder)
        })

    Image(painter = painter, contentDescription = "Loaded Image")
}