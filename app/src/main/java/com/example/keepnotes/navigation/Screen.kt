package com.example.keepnotes.navigation

enum class Screen {
    MainScreen,
    AddNoteScreen,
    UpdateNoteScreen;
    companion object {
        fun appRoute(route: String?): Screen
        = when (route?.substringBefore("/")) {
            MainScreen.name -> MainScreen
            AddNoteScreen.name -> AddNoteScreen
            UpdateNoteScreen.name -> UpdateNoteScreen
            null -> MainScreen
            else -> throw IllegalArgumentException("Route $route doesn't exist!")
        }
    }

}