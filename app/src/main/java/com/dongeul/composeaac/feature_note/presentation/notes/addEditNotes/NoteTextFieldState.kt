package com.dongeul.composeaac.feature_note.presentation.notes.addEditNotes

data class NoteTextFieldState(
    val text: String = "",
    val hint: String = "",
    val isHintVisible: Boolean = true
)
