package com.example.keepnotes.dependencyInjection

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Room
import androidx.room.TypeConverters
import com.example.keepnotes.data.KeepNoteDatabase
import com.example.keepnotes.data.NoteDatabaseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@RequiresApi(Build.VERSION_CODES.O)
@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun provideKeepNotesDao(keepNoteDatabase: KeepNoteDatabase): NoteDatabaseDao
    = keepNoteDatabase.keepNoteDao()

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): KeepNoteDatabase
    = Room.databaseBuilder(
        context,
        KeepNoteDatabase::class.java,
        "keepNotesDB")
        .fallbackToDestructiveMigration()
        .build()

}