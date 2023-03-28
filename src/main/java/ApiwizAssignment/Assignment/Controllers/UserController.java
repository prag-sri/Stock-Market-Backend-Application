package ApiwizAssignment.Assignment.Controllers;

import ApiwizAssignment.Assignment.RequestDTOs.UserRequestDTO;
import ApiwizAssignment.Assignment.Services.ServiceImplementation.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRequestDTO userRequestDTO)
    {
        userService.registerUser(userRequestDTO);
        return new ResponseEntity<>("User Registered Successfully!", HttpStatus.CREATED);
    }
}
