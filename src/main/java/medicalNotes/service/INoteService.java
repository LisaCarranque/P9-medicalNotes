package medicalNotes.service;

import medicalNotes.model.Note;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * This interface is responsible for managing patient history
 */
public interface INoteService {

    /**
     * This method is responsible for finding all patient notes
     *
     * @param uuid the uuid of the targeted patient
     * @return the list of notes for the targeted patient
     */
    List<Note> findAllPatientNotes(UUID uuid);

    /**
     * This method is responsible for adding a note
     *
     * @param note the note to add
     * @return the added note
     */
    Note addNote(Note note);

    /**
     * This method is responsible for updating a note
     *
     * @param note the note to be updated
     * @return the updated note
     */
    Note updateNote(Note note);

    /**
     * This method is responsible for finding a note by id
     *
     * @param id the id of the targeted note
     * @return If non-null, the value; if null, indicates no value is present
     */
    Optional<Note> findNoteById(String id);
}
