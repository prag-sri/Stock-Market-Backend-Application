package ApiwizAssignment.Assignment.RequestDTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDTO {

    private String first_name;
    private String last_name;
    private String email;
    private String phone_number;
    private String password;
}
