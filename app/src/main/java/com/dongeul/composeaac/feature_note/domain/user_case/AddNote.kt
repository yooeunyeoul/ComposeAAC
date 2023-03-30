package com.dongeul.composeaac.feature_note.domain.user_case

import androidx.compose.runtime.referentialEqualityPolicy
import com.dongeul.composeaac.feature_note.domain.model.InvalidNoteException
import com.dongeul.composeaac.feature_note.domain.model.Note
import com.dongeul.composeaac.feature_note.domain.repository.NoteRepository

class AddNote(private val repository: NoteRepository) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank()) {
            throw InvalidNoteException("The title of the note can't be empty.")
        }
        if (note.content.isBlank()) {
            throw InvalidNoteException("The content of the note can't be empty.")
        }
        repository.insertNote(note)
    }
}