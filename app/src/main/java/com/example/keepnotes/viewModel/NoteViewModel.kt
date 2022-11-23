package com.example.keepnotes.viewModel

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.keepnotes.model.NoteData
import com.example.keepnotes.repository.KeepNoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@RequiresApi(Build.VERSION_CODES.O)
@HiltViewModel
class NoteViewModel @Inject constructor(private val repository: KeepNoteRepository) : ViewModel() {


    private val _noteList = MutableStateFlow<List<NoteData>>(emptyList())
    val noteList = _noteList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllNotes().distinctUntilChanged()
                .collect { listNotes ->
                    if (listNotes.isEmpty()) {
                        Log.d("ListOfNotes", ": Empty")
                    }
                    _noteList.value = listNotes

                }
        }
    }

    fun addNote(note: NoteData) = viewModelScope.launch { repository.addNote(note) }
    fun removeNote(note: NoteData) = viewModelScope.launch { repository.deleteNote(note) }
    fun updateNote(note: NoteData) = viewModelScope.launch { repository.updateNote(note) }

}