package com.example.keepnotes.screen

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import com.example.keepnotes.components.DiscardButton
import com.example.keepnotes.components.SaveButton
import com.example.keepnotes.components.InputText
import com.example.keepnotes.navigation.Screen

@Composable
fun AddNoteScreen(navController: NavController) {

    var title by remember {
        mutableStateOf("")
    }

    var description by remember {
        mutableStateOf("")
    }

    val context = LocalContext.current

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background) {

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {

            Card(
                contentColor = MaterialTheme.colors.primary,
                backgroundColor = MaterialTheme.colors.background,
                elevation = 8.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp, top = 20.dp, bottom = 20.dp)) {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 15.dp, end = 15.dp, top = 10.dp, bottom = 40.dp)) {

                    InputText(
                        modifier = Modifier.fillMaxWidth(),
                        text = title,
                        label = "Title",
                        onTextChange = {
                            if (it.all { char ->
                                    char.isLetterOrDigit() || char.isWhitespace()
                                }) title = it
                        }
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    InputText(
                        modifier = Modifier.fillMaxWidth(),
                        text = description,
                        label = "Add note",
                        maxLine = 1000,
                        onTextChange = {
                                description = it
                        }
                    )
                }
            }
            
            Row() {
                DiscardButton(text = "Discard", onClick = {
                    navController.navigate(route = Screen.MainScreen.name)
                    title = ""
                    description = ""
                    Toast.makeText(context, "Discarded", Toast.LENGTH_SHORT).show()
                })
                
                Spacer(modifier = Modifier.width(10.dp))
                
                SaveButton(text = "Save", onClick = {

                    if (title.isNotEmpty() && description.isNotEmpty()) {
                        title = ""
                        description = ""
                        Toast.makeText(context, "Saved", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(context, "Fill the Title and Description", Toast.LENGTH_SHORT).show()
                    }
                })
            }
        }
    }
}