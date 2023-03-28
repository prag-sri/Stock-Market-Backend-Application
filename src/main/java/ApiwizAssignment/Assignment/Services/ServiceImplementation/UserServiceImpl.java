package ApiwizAssignment.Assignment.Services.ServiceImplementation;

import static org.springframework.data.mongodb.core.query.Query.query;
import java.util.Objects;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import ApiwizAssignment.Assignment.Entities.DatabaseSequence;
import ApiwizAssignment.Assignment.Entities.User;
import ApiwizAssignment.Assignment.Repositories.UserRepository;
import ApiwizAssignment.Assignment.RequestDTOs.UserRequestDTO;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserServiceImpl {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private  MongoOperations mongoOperations;

    @Autowired
    public UserServiceImpl(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    public void registerUser(@RequestBody UserRequestDTO userRequestDTO)
    {
        User user= User.builder()
                .first_name(userRequestDTO.getFirst_name())
                .last_name(userRequestDTO.getLast_name())
                .email(userRequestDTO.getEmail())
                .phone_number(userRequestDTO.getPhone_number())
                .password(userRequestDTO.getPassword()).build();
        user.setId(generateSequence(User.sequence_num));
        userRepository.save(user);
    }

    public int generateSequence(String seqName)
    {
        DatabaseSequence counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
                new Update().inc("seq", 1), options().returnNew(true).upsert(true),
                DatabaseSequence.class);
        return (int) (!Objects.isNull(counter) ? counter.getSeq() : 1);
    }
}
