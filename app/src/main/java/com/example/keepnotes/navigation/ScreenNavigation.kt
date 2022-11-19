package com.example.keepnotes.navigation

import android.net.http.SslCertificate
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.keepnotes.screen.AddNoteScreen
import com.example.keepnotes.screen.MainScreen

@Composable
fun ScreenNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.MainScreen.name) {

        composable(Screen.MainScreen.name) { MainScreen(navController) }

        composable(Screen.AddNoteScreen.name) { AddNoteScreen() }

    }
}