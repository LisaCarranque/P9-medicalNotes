package medicalNotes.model;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * This class is responsible for testing Note model
 */
@ExtendWith(MockitoExtension.class)
public class NoteTest {

    @InjectMocks
    Note note;

    @Test
    public void testGetAndSetNote() {
        UUID uuid = UUID.randomUUID();
        Note note = Note.builder().build();
        note.setContent("content");
        note.setUuid(uuid);
        note.setId("1");
        assertNotNull(note);
        assertEquals(uuid, note.getUuid());
        assertEquals("content", note.getContent());
        assertEquals("1", note.getId());
    }

    @Test
    public void testBuildNote() {
        UUID uuid = UUID.randomUUID();
        Note note = Note.builder().id("1").content("content").uuid(uuid).build();
        assertNotNull(note);
        assertEquals("1", note.getId());
        assertEquals("content", note.getContent());
        assertEquals(uuid, note.getUuid());
    }

    @Test
    public void testNoArgumentConstructorPatient() {
        Note note = Note.builder().build();
        assertNotNull(note);
    }

}
