package nl.novi.nlbank.repository;

import nl.novi.nlbank.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
