package com.example.keepnotes.data


import android.os.Build
import androidx.annotation.RequiresApi
import com.example.keepnotes.model.NoteData


@RequiresApi(Build.VERSION_CODES.O)
class NoteDummyDataSource {
    fun loadNotes(): List<NoteData> {
        return listOf(

            NoteData(title = "Lorem ipsum dolor sit amet.", description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus efficitur euismod orci ut cursus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed accumsan tortor ante, et euismod tellus tempus."),
            NoteData(title = "Lorem ipsum dolor sit amet.", description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus efficitur euismod orci ut cursus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed accumsan tortor ante, et euismod tellus tempus."),
            NoteData(title = "Lorem ipsum dolor sit amet.", description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus efficitur euismod orci ut cursus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed accumsan tortor ante, et euismod tellus tempus."),
            NoteData(title = "Lorem ipsum dolor sit amet.", description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus efficitur euismod orci ut cursus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed accumsan tortor ante, et euismod tellus tempus."),
            NoteData(title = "Lorem ipsum dolor sit amet.", description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus efficitur euismod orci ut cursus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed accumsan tortor ante, et euismod tellus tempus.")


        )
    }
}
