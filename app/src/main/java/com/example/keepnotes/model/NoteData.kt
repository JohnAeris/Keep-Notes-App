package com.example.keepnotes.model

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant
import java.util.*

@RequiresApi(Build.VERSION_CODES.O)
@Entity(tableName = "KeepNotesTable")
data class NoteData (
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),

    @ColumnInfo(name = "noteTitle")
    var title: String,

    @ColumnInfo(name = "noteDescription")
    var description: String,

    @ColumnInfo(name = "noteDate")
    val date: Date = Date.from(Instant.now())
)
