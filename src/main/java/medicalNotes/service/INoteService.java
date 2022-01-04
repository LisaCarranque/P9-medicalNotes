package medicalNotes.service;

import medicalNotes.model.Note;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * This interface is responsible for managing patient history
 */
public interface INoteService {

    List<Note> findAllPatientNotes(UUID uuid);

    Note addNote(Note note);

    Note updateNote(Note note);

    List<Note> findAll();

    Optional<Note> findNoteById(String id);
}
