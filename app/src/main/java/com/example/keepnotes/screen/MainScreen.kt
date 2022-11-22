package com.example.keepnotes.screen

import android.os.Build
import android.provider.ContactsContract.CommonDataKinds.Note
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.room.TypeConverter
import com.example.keepnotes.data.NoteDummyDataSource
import com.example.keepnotes.model.NoteData
import com.example.keepnotes.navigation.Screen
import com.example.keepnotes.utility.dateFormat
import com.example.keepnotes.viewModel.NoteViewModel
import java.time.format.DateTimeFormatter


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MainScreen(
    navController: NavController,
    noteList: List<NoteData>,
    removeNote: (NoteData) -> Unit
) {
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
        MainContent(notes = noteList, onRemoved = removeNote)
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MainContent(notes: List<NoteData>, onRemoved: (NoteData) -> Unit) {

    LazyColumn(modifier = Modifier.background(color = MaterialTheme.colors.primaryVariant)) {

        items(notes) { note ->
            NoteCard(note = note, onRemoved = { onRemoved(note) })
        }

    }

}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NoteCard(note: NoteData, onRemoved: (NoteData) -> Unit) {

    val context = LocalContext.current

    Card(
        backgroundColor = MaterialTheme.colors.background,
        contentColor = MaterialTheme.colors.primary,
        shape = RoundedCornerShape(CornerSize(8.dp)),
        modifier = Modifier
            .padding(start = 15.dp, end = 15.dp, top = 10.dp, bottom = 10.dp)
            .fillMaxWidth()
            .wrapContentHeight()) {

        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.padding(10.dp)) {

            Row() {
                Text(
                    text = note.title,
                    style = MaterialTheme.typography.h2,
                    color = MaterialTheme.colors.primary,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.weight(1f)
                )

                Column(horizontalAlignment = Alignment.End) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Delete Button",
                        modifier = Modifier
                            .size(20.dp)
                            .clickable {
                                onRemoved(note)
                                Toast.makeText(context, "Remove", Toast.LENGTH_SHORT).show()
                            }
                    )
                }
            }

            Column(horizontalAlignment = Alignment.Start) {
                Text(
                    text = note.description,
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.primary,
                    textAlign = TextAlign.Justify
                )
            }
            
            Row() {
                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = dateFormat(note.date.time),
                    style = MaterialTheme.typography.caption,
                    color = MaterialTheme.colors.primary)
            }

        }

    }
    
}