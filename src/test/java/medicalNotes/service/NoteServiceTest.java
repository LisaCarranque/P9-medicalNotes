package medicalNotes.service;

import medicalNotes.model.Note;
import medicalNotes.repository.NoteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;

/**
 * This class is responsible for testing NoteService
 */
@ExtendWith(MockitoExtension.class)
public class NoteServiceTest {

    @InjectMocks
    NoteService noteService;

    @Mock
    NoteRepository noteRepository;

    @Test
    public void loadService() {
        assertNotNull(noteRepository);
    }

    @Test
    public void addNoteTest() {
        Note note = Note.builder().content("Body Height").uuid(UUID.randomUUID()).id("1").build();
        noteService.addNote(note);
        verify(noteRepository).save(note);
    }

    @Test
    public void updateNoteTest() {
        Note note = Note.builder().content("Cholesterol").uuid(UUID.randomUUID()).id("1").build();
        noteService.updateNote(note);
        verify(noteRepository).save(note);
    }

    @Test
    public void getNoteById() {
        noteService.findNoteById("1");
        verify(noteRepository).findById("1");
    }

    @Test
    public void findAllPatientNotesTest() {
        UUID uuid = UUID.randomUUID();
        noteService.findAllPatientNotes(uuid);
        verify(noteRepository).findAllByUuid(uuid);
    }

}
