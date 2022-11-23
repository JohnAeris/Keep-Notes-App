package com.example.keepnotes.model

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

@RequiresApi(Build.VERSION_CODES.O)
@Entity(tableName = "KeepNotesTable")
data class NoteData (
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),

    @ColumnInfo(name = "noteTitle")
    val title: String,

    @ColumnInfo(name = "noteDescription")
    val description: String,

    @ColumnInfo(name = "noteDate")
    val date: Date = Date.from(Instant.now())
)
