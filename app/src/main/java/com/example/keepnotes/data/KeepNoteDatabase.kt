package com.example.keepnotes.data

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.keepnotes.model.NoteData
import com.example.keepnotes.utility.DateConverter

@RequiresApi(Build.VERSION_CODES.O)
@Database(entities = [NoteData::class], version = 2, exportSchema = false)
@TypeConverters(DateConverter::class)
abstract class KeepNoteDatabase: RoomDatabase() {

    abstract fun keepNoteDao(): NoteDatabaseDao

}
