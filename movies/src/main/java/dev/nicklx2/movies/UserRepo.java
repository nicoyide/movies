package dev.nicklx2.movies;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User,String>{
    Optional<User>findUserByEmail(String email);
}