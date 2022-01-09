package medicalNotes.repository;

import medicalNotes.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface NoteRepository extends MongoRepository<Note, String> {

    List<Note> findAllByUuid(UUID uuid);

}
