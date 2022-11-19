package com.example.keepnotes.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.keepnotes.components.DiscardButton
import com.example.keepnotes.components.SaveButton
import com.example.keepnotes.components.InputText

@Composable
fun AddNoteScreen() {

    var title by remember {
        mutableStateOf("")
    }

    var description by remember {
        mutableStateOf("")
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background) {

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {

            Card(
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
                        onTextChange = {}
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    InputText(
                        modifier = Modifier.fillMaxWidth(),
                        text = description,
                        label = "Add note",
                        maxLine = 1000,
                        onTextChange = {}
                    )
                }
            }
            
            Row() {
                DiscardButton(text = "Discard", onClick = { /*TODO*/ })
                
                Spacer(modifier = Modifier.width(10.dp))
                
                SaveButton(text = "Save", onClick = { /*TODO*/ })
            }
        }
    }
}