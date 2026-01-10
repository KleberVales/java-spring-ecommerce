package org.example.javaspringecommerce.service;

import org.example.javaspringecommerce.domain.user.User;
import org.example.javaspringecommerce.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    // ================== User Save ================================

    public User create(String username, String password, String email) {

        User user = new User();

        user.setUsername(username);
        user.setEmail(email);
        user.setPasswordHash(password);


        return repository.save(user);
    }

    // ================= Read operation ==============================

}
