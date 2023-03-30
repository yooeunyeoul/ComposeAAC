package com.dongeul.composeaac.feature_note.domain.user_case

class NoteUseCases(
    val getNotesUseCase: GetNotesUseCase,
    val deleteNote: DeleteNote,
    val addNote : AddNote,
    val getNote: GetNote

) {
}