package ApiwizAssignment.Assignment.Entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.validation.constraints.Email;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private String id;
    private String first_name;
    private String last_name;
    @Email
    private String email;
    private String phone_no;
    private String password;

    @DBRef
    private Set<Role> roles = new HashSet<>();

    public User(String email, String password) {
        this.email= email;
        this.password= password;
    }
}