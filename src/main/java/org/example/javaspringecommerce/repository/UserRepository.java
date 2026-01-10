package org.example.javaspringecommerce.repository;

import org.example.javaspringecommerce.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {


}
