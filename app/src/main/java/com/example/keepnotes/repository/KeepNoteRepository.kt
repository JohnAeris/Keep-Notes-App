package com.example.keepnotes.repository

import android.provider.ContactsContract.CommonDataKinds.Note
import com.example.keepnotes.data.NoteDatabaseDao
import com.example.keepnotes.model.NoteData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class KeepNoteRepository @Inject constructor(private val noteDatabaseDao: NoteDatabaseDao) {

    suspend fun addNote(note: NoteData) = noteDatabaseDao.insertNote(note)
    suspend fun updateNote(note: NoteData) = noteDatabaseDao.updateNote(note)
    suspend fun deleteNote(note: NoteData) = noteDatabaseDao.deleteNote(note)
    suspend fun deleteAllNotes() = noteDatabaseDao.deleteAllNote()
    suspend fun getAllNotes(): Flow<List<NoteData>> = noteDatabaseDao.getAllNotes().flowOn(Dispatchers.IO)
        .conflate()


}