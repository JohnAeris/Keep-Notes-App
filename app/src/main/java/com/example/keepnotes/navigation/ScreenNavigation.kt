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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.keepnotes.viewModel.NoteViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ScreenNavigation(noteViewModel: NoteViewModel = viewModel()) {
    val noteList = noteViewModel.getAllNotes()
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.MainScreen.name) {

        composable(Screen.MainScreen.name){
            MainScreen(navController = navController, noteList = noteList, removeNote = { noteViewModel.removeNote(it) })}

        composable(Screen.AddNoteScreen.name){



            AddNoteScreen(navController = navController, addNote = { noteViewModel.addNote(it) })
        }

    }
}