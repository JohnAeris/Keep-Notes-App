package com.example.keepnotes.screen

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.keepnotes.components.DiscardButton
import com.example.keepnotes.components.SaveButton
import com.example.keepnotes.components.InputText
import com.example.keepnotes.data.NoteDummyDataSource
import com.example.keepnotes.model.NoteData
import com.example.keepnotes.navigation.Screen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AddNoteScreen(
    navController: NavController,
    addNote: (NoteData) -> Unit
) {

    var title by remember {
        mutableStateOf("")
    }

    var description by remember {
        mutableStateOf("")
    }

    val context = LocalContext.current

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.primaryVariant) {

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
                        modifier = Modifier.fillMaxWidth().fillMaxHeight(0.5f),
                        text = description,
                        label = "Add note",
                        maxLine = 1000,
                        imeAction = ImeAction.None,
                        onTextChange = {
                                description = it
                        }
                    )
                }
            }
            
            Row() {
                DiscardButton(text = "Discard", onClick = {

                    if (title.isNotEmpty() && description.isNotEmpty()) {
                        navController.navigate(route = Screen.MainScreen.name)
                        title = ""
                        description = ""
                        Toast.makeText(context, "Note Discarded", Toast.LENGTH_SHORT).show()
                    } else {
                        //Nothing
                    }
                })
                
                Spacer(modifier = Modifier.width(10.dp))
                
                SaveButton(text = "Save", onClick = {

                    if (title.isNotEmpty() && description.isNotEmpty()) {
                        addNote(NoteData(title = title, description = description))
                        title = ""
                        description = ""
                        navController.navigate(route = Screen.MainScreen.name)
                        Toast.makeText(context, "Note Saved", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(context, "Fill the Title and Description", Toast.LENGTH_SHORT).show()
                    }
                })
            }
        }
    }
}