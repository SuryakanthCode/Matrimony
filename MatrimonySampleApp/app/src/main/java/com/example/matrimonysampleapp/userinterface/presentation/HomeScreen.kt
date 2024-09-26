package com.example.matrimonysampleapp.userinterface.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.matrimonysampleapp.userinterface.presentation.components.ProfileItem
import com.example.matrimonysampleapp.ui.theme.backgroundColor
import com.example.matrimonysampleapp.userinterface.presentation.components.RoundedCornerChip
import com.example.matrimonysampleapp.userinterface.presentation.home.ProfileScreen
import com.example.matrimonysampleapp.userinterface.presentation.utils.RouteScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val state = viewModel.state.value
    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        viewModel.onEvent(EVENT.ONINSERT.name)
        viewModel.onEvent(EVENT.ONVIEW.name)
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        containerColor = backgroundColor
    ) {
        Column(
            modifier = Modifier.padding(
                top = 60.dp,
                start = 20.dp,
                end = 20.dp,
                bottom = 20.dp
            )
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "My Matches",
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp
                )
                Icon(
                    modifier = Modifier
                        .size(30.dp)
                        .clickable {
                            navController.navigate(RouteScreen.ProfileScreen.route)
                        },
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "more Icon",
                    tint = Color.White
                )
            }
            Spacer(modifier = Modifier.height(30.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "8 Profiles pending with me",
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.width(10.dp))
                RoundedCornerChip()
            }

            LazyRow(modifier = Modifier.fillMaxSize()) {
                items(state.profiles) { profile ->
                    ProfileItem(profile = profile, modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .clickable {
                            navController.navigate(RouteScreen.GestureScreen.route)
                        })
                }
            }
        }
    }
}



