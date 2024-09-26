package com.example.matrimonysampleapp.userinterface.presentation.components

import androidx.annotation.DrawableRes
import com.example.matrimonysampleapp.R

data class MatchProfile(
    val name: String,
    @DrawableRes val drawableResId: Int,
)

val profiles = listOf(
    MatchProfile("Erlich Bachman", R.drawable.placeholder),
    MatchProfile("Richard Hendricks", R.drawable.error),
    MatchProfile("Laurie Bream", R.drawable.placeholder),
    MatchProfile("Russ Hanneman", R.drawable.error),
)