package com.example.keepnotes.navigation

enum class Screen {
    MainScreen,
    AddNoteScreen;
    companion object {
        fun appRoute(route: String?): Screen
        = when (route?.substringBefore("/")) {
            MainScreen.name -> MainScreen
            AddNoteScreen.name -> AddNoteScreen
            null -> MainScreen
            else -> throw IllegalArgumentException("Route $route doesn't exist!")
        }
    }

}