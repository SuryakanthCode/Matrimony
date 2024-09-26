package com.example.matrimonysampleapp.userinterface.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.matrimonysampleapp.ui.theme.MatrimonySampleAppTheme
import com.example.matrimonysampleapp.userinterface.presentation.components.SetupTransparentSystemUi
import com.example.matrimonysampleapp.userinterface.presentation.home.ProfileScreen
import com.example.matrimonysampleapp.userinterface.presentation.utils.RouteScreen
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            MatrimonySampleAppTheme {
                SetupTransparentSystemUi(
                    systemUiController = rememberSystemUiController(),
                    actualBackgroundColor = MaterialTheme.colorScheme.background
                )
                Surface {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = RouteScreen.HomeScreen.route
                    ) {
                        composable(route = RouteScreen.HomeScreen.route) {
                            HomeScreen(navController = navController)
                        }
                        composable(route = RouteScreen.ProfileScreen.route) {
                            ProfileScreen(navController = navController)
                        }
                        composable(route = RouteScreen.GestureScreen.route) {
                            GestureScreen(navController = navController)
                        }
                        /*composable(
                            route = Screen.AddEditNoteScreen.route +
                                    "?noteId={noteId}&noteColor={noteColor}",
                            arguments = listOf(
                                navArgument(
                                    name = "noteId"
                                ) {
                                    type = NavType.IntType
                                    defaultValue = -1
                                },
                                navArgument(
                                    name = "noteColor"
                                ) {
                                    type = NavType.IntType
                                    defaultValue = -1
                                },
                            )
                        ) {
                            val color = it.arguments?.getInt("noteColor") ?: -1
                            AddEditNoteScreen(
                                navController = navController,
                                noteColor = color
                            )
                        }*/
                    }
                }
            }
        }
    }
}