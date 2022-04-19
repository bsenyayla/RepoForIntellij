package edu.mum.cs245.eregistrar.repository;

import edu.mum.cs245.eregistrar.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);
}
