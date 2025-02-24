package Journal.example.Journal.project.Repository;

import Journal.example.Journal.project.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface User_repo extends MongoRepository<User, String> {
     User findByUsername(String username);

     void deleteByUsername(String username);
}
