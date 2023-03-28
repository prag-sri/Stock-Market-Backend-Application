package ApiwizAssignment.Assignment.Entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class User {

    @Transient
    public static final String sequence_num= "users_Sequence";
    @Id
    private int id;
    private String first_name;
    private String last_name;
    private String email;
    private String phone_number;
    private String password;
}
