package ApiwizAssignment.Assignment.Repositories;

import ApiwizAssignment.Assignment.Entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User,Integer> {

    Optional<User> findByEmail(String email);
}
