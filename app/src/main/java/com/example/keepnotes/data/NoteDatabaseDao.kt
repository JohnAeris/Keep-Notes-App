package com.example.keepnotes.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.keepnotes.model.NoteData
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDatabaseDao {

    @Query("SELECT * FROM KeepNotesTable")
    fun getAllNotes(): Flow<List<NoteData>>

    @Query("SELECT * FROM KeepNotesTable WHERE id =:id")
    suspend fun getNoteById(id: String): NoteData

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: NoteData)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateNote(note: NoteData)

    @Query("DELETE FROM KeepNotesTable")
    suspend fun deleteAllNote()

    @Delete
    suspend fun deleteNote(note: NoteData)

}
