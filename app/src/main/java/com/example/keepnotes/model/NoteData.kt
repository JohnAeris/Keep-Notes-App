package com.example.keepnotes.model

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

@RequiresApi(Build.VERSION_CODES.O)
data class NoteData (
    val id: UUID = UUID.randomUUID(),
    val title: String,
    val description: String,
    val date: LocalDateTime = LocalDateTime.now()
)
