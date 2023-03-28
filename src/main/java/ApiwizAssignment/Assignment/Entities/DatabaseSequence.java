package ApiwizAssignment.Assignment.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Document(collection = "database_sequences")
@Component
@Getter
@Setter
@NoArgsConstructor
public class DatabaseSequence {

    @Id
    private String id;
    private long seq;
}
