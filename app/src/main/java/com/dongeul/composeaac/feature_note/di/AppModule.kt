package com.dongeul.composeaac.feature_note.di

import android.app.Application
import androidx.room.Room
import com.dongeul.composeaac.feature_note.data.data_source.NoteDao
import com.dongeul.composeaac.feature_note.data.data_source.NoteDatabase
import com.dongeul.composeaac.feature_note.data.repository.NoteRepositoryImpl
import com.dongeul.composeaac.feature_note.domain.repository.NoteRepository
import com.dongeul.composeaac.feature_note.domain.user_case.AddNote
import com.dongeul.composeaac.feature_note.domain.user_case.DeleteNote
import com.dongeul.composeaac.feature_note.domain.user_case.GetNotesUseCase
import com.dongeul.composeaac.feature_note.domain.user_case.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app, NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotesUseCase = GetNotesUseCase(repository),
            deleteNote = DeleteNote(repository),
            addNote = AddNote(repository)
        )
    }
}