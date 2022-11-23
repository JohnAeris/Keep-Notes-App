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
import com.example.keepnotes.model.NoteData
import com.example.keepnotes.navigation.Screen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun UpdateNoteScreen(
    noteList: List<NoteData>,
    navController: NavController,
    updateNote: (NoteData) -> Unit,
    NoteId: String?,
) {
    val fetchNote = noteList.filter { note ->
        note.id == NoteId
    }

    val noteTitle = fetchNote.firstOrNull()?.title
    val noteDescription = fetchNote.firstOrNull()?.description


    var title1 = if (noteTitle?.isEmpty() == true) {
        "Empty"
    } else {
        noteTitle.toString()
    }

    var description1 = if (noteDescription?.isEmpty() == true) {
        "Empty"
    } else {
        noteDescription.toString()
    }

    var title by remember {
        mutableStateOf(title1)
    }

    var description by remember {
        mutableStateOf(description1)
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
                        label = "",
                        onTextChange = {
                            title = it
                        }
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    InputText(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.5f),
                        text = description,
                        label = "",
                        maxLine = 1000,
                        imeAction = ImeAction.None,
                        onTextChange = {
                            description = it
                        }
                    )
                }
            }

            Row() {
                DiscardButton(text = "Cancel", onClick = {
                    navController.navigate(route = Screen.MainScreen.name)
                })

                Spacer(modifier = Modifier.width(10.dp))

                SaveButton(text = "Update", onClick = {
                    if (title.isNotEmpty() && description.isNotEmpty()) {
                        updateNote(NoteData(title = title, description = description))
                        Toast.makeText(context, "Successfully Updated", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(context, "Fill the Title and Description", Toast.LENGTH_SHORT).show()
                    }
                })
            }
        }
    }
}