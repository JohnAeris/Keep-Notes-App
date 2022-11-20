package com.example.keepnotes.viewModel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.keepnotes.data.NoteDummyDataSource
import com.example.keepnotes.model.NoteData

@RequiresApi(Build.VERSION_CODES.O)
class NoteViewModel : ViewModel() {

    var noteList = mutableStateListOf<NoteData>()

    init {
        noteList.addAll(NoteDummyDataSource().loadNotes())
    }

    fun addNote(note: NoteData) {
        noteList.add(note)
    }

    fun removeNote(note: NoteData) {
        noteList.remove(note)
    }

    fun getAllNotes(): List<NoteData> {
        return noteList
    }





}