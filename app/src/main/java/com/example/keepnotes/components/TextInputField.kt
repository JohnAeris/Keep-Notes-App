package com.example.keepnotes.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import com.example.keepnotes.R

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun InputText(
    modifier: Modifier = Modifier,
    text: String,
    label: String,
    maxLine: Int = 1,
    onTextChange: (String) -> Unit,
    onImeAction: () -> Unit = {})
{
    val keyBoardController = LocalSoftwareKeyboardController.current
    
    TextField(
        value = text,
        onValueChange = onTextChange,
        maxLines = maxLine,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.background),
        label = { Text(
            text = label,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colors.primary)},
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(
            onDone = {
                onImeAction()
                keyBoardController?.hide()
            }),
        modifier = modifier
    )
}