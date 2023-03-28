package ApiwizAssignment.Assignment.Config;

import ApiwizAssignment.Assignment.Entities.User;
import ApiwizAssignment.Assignment.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //loading user from database by username
        User user= this.userRepository.findByEmail(username).orElseThrow(()->new ResourceNotFoundException("User","email: "+username,0));
        return user;
    }
}
