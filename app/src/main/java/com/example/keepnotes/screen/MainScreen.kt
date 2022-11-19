package com.example.keepnotes.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.keepnotes.navigation.Screen

@Composable
fun MainScreen(navController: NavController) {
    val context = LocalContext.current

    Scaffold(

        topBar = {
            TopAppBar(
                backgroundColor = MaterialTheme.colors.secondaryVariant,
                elevation = 8.dp,
                modifier = Modifier.padding(5.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Keep Notes",
                        style = MaterialTheme.typography.h1,
                        color = MaterialTheme.colors.primary
                    )
                }
            } },

        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(route = Screen.AddNoteScreen.name)
                    Toast.makeText(context, "Create Note", Toast.LENGTH_SHORT).show() },
                backgroundColor = MaterialTheme.colors.secondary
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add Button",
                    tint = MaterialTheme.colors.primaryVariant,
                    modifier = Modifier.size(30.dp)
                )
            } },

        floatingActionButtonPosition = FabPosition.Center)
    {
        MainContent()
    }
}

@Composable
fun MainContent() {
    Column() {
        Text(text = "Hello World", color = MaterialTheme.colors.primary)
    }
}