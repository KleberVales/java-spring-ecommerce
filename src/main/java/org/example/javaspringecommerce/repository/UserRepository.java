package org.example.javaspringecommerce.repository;

import org.example.javaspringecommerce.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUsernameOrEmail(String username, String email);

}
