package medicalNotes.controller;

import medicalNotes.exception.NoteNotFoundException;
import medicalNotes.model.Note;
import medicalNotes.service.NoteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * This class is responsible for testing NoteController
 */
@ExtendWith(MockitoExtension.class)
public class NoteControllerTest {

    @InjectMocks
    NoteController noteController;

    @Mock
    NoteService noteService;

    @Mock
    Model model;

    @Test
    public void loadController() {
        assertNotNull(noteController);
    }

    @Test
    public void updateNoteTest() {
        when(noteService.findNoteById(any())).thenReturn(java.util.Optional.ofNullable(Note.builder().id("1").uuid(UUID.randomUUID()).content("Dizziness").build()));
        noteController.updateNoteInformation(any());
        verify(noteService).findNoteById(any());
    }

    @Test
    public void updateNoteThrowsExceptionTest() {
        assertThrows(NoteNotFoundException.class, () -> noteController.updateNoteInformation(any()));
    }


    @Test
    public void validateNoteTest() {
        Note note = Note.builder().content("Dizziness").uuid(UUID.randomUUID()).id("1").build();
        noteController.validateUpdate(note);
        verify(noteService).updateNote(note);
    }

    @Test
    public void addNoteTest() {
        Note note = Note.builder().content("Dizziness").uuid(UUID.randomUUID()).id("1").build();
        noteController.addNote(note);
        verify(noteService).addNote(note);
    }

    @Test
    public void findAllPatientNotesTest() {
        UUID uuid = UUID.randomUUID();
        noteController.findNotesByUuid(uuid.toString());
        verify(noteService).findAllPatientNotes(uuid);
    }

}
