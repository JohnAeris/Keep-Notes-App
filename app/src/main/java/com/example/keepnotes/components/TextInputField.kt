package com.example.keepnotes.components


import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun InputText(
    modifier: Modifier = Modifier,
    text: String,
    label: String,
    maxLine: Int = 1,
    onTextChange: (String) -> Unit,
    imeAction: ImeAction = ImeAction.Next,
    onImeAction: () -> Unit = {})
{
    val keyBoardController = LocalSoftwareKeyboardController.current
    
    TextField(
        value = text,
        textStyle = MaterialTheme.typography.body1,
        onValueChange = onTextChange,
        maxLines = maxLine,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.background),
        label = { Text(
            text = label,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colors.primary)},
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = imeAction),
        keyboardActions = KeyboardActions(
            onDone = {
                onImeAction()
                keyBoardController?.hide()
            }),
        modifier = modifier
    )
}