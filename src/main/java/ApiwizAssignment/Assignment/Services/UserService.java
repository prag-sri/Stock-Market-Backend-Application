package ApiwizAssignment.Assignment.Services;

import ApiwizAssignment.Assignment.RequestDTOs.UserRequestDTO;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserService {
    public void registerUser(@RequestBody UserRequestDTO userRequestDTO);
}
