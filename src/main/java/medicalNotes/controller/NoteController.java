package medicalNotes.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import medicalNotes.exception.NoteNotFoundException;
import medicalNotes.model.Note;
import medicalNotes.service.INoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

/**
 * This controller is responsible for patient history
 */
@Slf4j
@RestController
@Api("Rest API for Note endpoints")
public class NoteController {

    @Autowired
    INoteService noteService;

    /**
     * This method is responsible for adding a note to patient historu
     *
     * @param note the note to be added
     * @return the added note
     */
    @PostMapping("/patientHistory/add")
    public ResponseEntity<Note> addNote(@RequestBody @Valid Note note) {
        log.info("medicalNotes controller: adding note with uuid: " + note.getUuid());
        Note noteAdded = noteService.addNote(note);
        if (Objects.isNull(noteAdded)) {
            return ResponseEntity.noContent().build();
        }
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(noteAdded.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    /**
     * This method is responsible for getting note information for further update
     *
     * @param id the id of the targeted note
     * @return the note to update
     */
    @GetMapping("/patientHistory/update/{id}")
    public Note updateNoteInformation(@PathVariable String id) {
        log.info("medicalNotes controller: finding note with id: " + id);
        Note note = noteService.findNoteById(id).orElse(null);
        if (note == null) throw new NoteNotFoundException("Note not found for id: " + id);
        return note;
    }

    /**
     * This note is responsible for updating note information
     *
     * @param note the note to udpate
     * @return the updated note
     */
    @PostMapping("/patientHistory/update")
    public Note validateUpdate(@RequestBody @Valid Note note) {
        log.info("medicalNotes controller: updating note with id: " + note.getId());
        return noteService.updateNote(note);
    }

    /**
     * This method is responsible for finding a note by patient uuid
     *
     * @param uuid the uuid of the targeted patient
     * @return the list of notes for this patient
     */
    @GetMapping("/patientHistory/findNotesByUuid/{uuid}")
    public List<Note> findNotesByUuid(@PathVariable String uuid) {
        log.info("medicalNotes controller: finding notes for patient with uuid: " + uuid);
        return noteService.findAllPatientNotes(UUID.fromString(uuid));
    }


}
