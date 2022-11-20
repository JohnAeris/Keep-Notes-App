package com.example.keepnotes.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.keepnotes.model.NoteData
import com.example.keepnotes.screen.AddNoteScreen
import com.example.keepnotes.screen.MainScreen
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ScreenNavigation() {
    val navController = rememberNavController()
    val noteList = remember { mutableStateListOf<NoteData>() }

    NavHost(navController = navController, startDestination = Screen.MainScreen.name) {

        composable(Screen.MainScreen.name){
            MainScreen(navController = navController, noteList = noteList, removeNote = { noteList.remove(it) })}

        composable(Screen.AddNoteScreen.name){



            AddNoteScreen(navController = navController, addNote = { noteList.add(it) })
        }

    }
}