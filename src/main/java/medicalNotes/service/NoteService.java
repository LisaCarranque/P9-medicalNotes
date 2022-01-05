package medicalNotes.service;

import lombok.extern.slf4j.Slf4j;
import medicalNotes.model.Note;
import medicalNotes.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class NoteService implements INoteService {

    boolean testMode = true;

    @Autowired
    NoteRepository noteRepository;

    /**
     * This method is responsible for finding all patient notes
     *
     * @param uuid the uuid of the targeted patient
     * @return the list of notes for the targeted patient
     */
    @Override
    public List<Note> findAllPatientNotes(UUID uuid) {
        log.info("medicalNotes service: finding notes for patient with uuid: " + uuid);
        return noteRepository.findAllByUuid(uuid);
    }

    /**
     * This method is responsible for adding a note
     *
     * @param note the note to add
     * @return the added note
     */
    @Override
    public Note addNote(Note note) {
        log.info("medicalNotes service: adding note with uuid: " + note.getUuid());
        return noteRepository.save(note);
    }

    /**
     * This method is responsible for updating a note
     *
     * @param note the note to be updated
     * @return the updated note
     */
    @Override
    public Note updateNote(Note note) {
        log.info("medicalNotes service: updating note with id: " + note.getId());
        return noteRepository.save(note);
    }

    /**
     * This method is responsible for finding a note by id
     *
     * @param id the id of the targeted note
     * @return If non-null, the value; if null, indicates no value is present
     */
    @Override
    public Optional<Note> findNoteById(String id) {
        log.info("medicalNotes service: finding note by id: " + id);
        return noteRepository.findById(id);
    }

}
