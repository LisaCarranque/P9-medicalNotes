package medicalNotes.controller;

import lombok.extern.slf4j.Slf4j;
import medicalNotes.model.Note;
import medicalNotes.service.INoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * This controller is responsible for patient history
 */
@Slf4j
@RestController
public class NoteController {

    @Autowired
    INoteService noteService;


    /**
     * This method is responsible for finding all notes
     * @return the list of all notes
     */
    @RequestMapping("/note/list")
    public List<Note> listNote() {
        return noteService.findAll();
    }

    /**
     * This method is responsible for adding a note to patient historu
     * @param note the note to be added
     * @return the added note
     */
    @RequestMapping("/note/add")
    public Note addNote(@RequestBody Note note) {
        return noteService.addNote(note);
    }


    /**
     * This method is responsible for getting note information for further update
     * @param id the id of the targeted note
     * @return the note to update
     */
    @RequestMapping("/note/update/{id}")
    public Note updateNoteInformation(@PathVariable String id) {
        return noteService.findNoteById(id).orElse(null);
    }

    /**
     * This note is responsible for updating note information
     * @param note the note to udpate
     * @return the updated note
     */
    @RequestMapping("/note/update")
    public Note validateUpdate(@RequestBody Note note) {
        return noteService.updateNote(note);
    }

    /**
     * This method is responsible for finding a note by patient uuid
     * @param uuid the uuid of the targeted patient
     * @return the list of notes for this patient
     */
    @RequestMapping("/note/findNotesByUuid/{uuid}")
    public List<Note> findNotesByUuid(@PathVariable String uuid) {
        return noteService.findAllPatientNotes(UUID.fromString(uuid));
    }

    /**
     * This method is responsible for finding a note by id
     * @param id the id of the targeted note
     * @return the note targeted by id
     */
    @RequestMapping("/note/findNoteById/{id}")
    public Optional<Note> findNoteById(@PathVariable String id) {
        return noteService.findNoteById(id);
    }


}
