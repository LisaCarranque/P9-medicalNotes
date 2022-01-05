package medicalNotes.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.util.UUID;

/**
 * This class is a model for note
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "note")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Generated
public class Note {

    @Id
    String id;
    @Field("content")
    @NotEmpty
    @NonNull
    String content;
    @Field("uuid")
    UUID uuid;

}
