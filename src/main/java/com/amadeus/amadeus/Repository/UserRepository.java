package com.amadeus.amadeus.Repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.amadeus.amadeus.Models.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);

    User findByUsernameOrEmail(String username, String email);


    Boolean existsByEmail(String email);
    Boolean existsByUsername(String username);

   
    


}
