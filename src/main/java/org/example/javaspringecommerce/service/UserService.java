package org.example.javaspringecommerce.service;

import jakarta.transaction.Transactional;
import org.example.javaspringecommerce.domain.user.Role;
import org.example.javaspringecommerce.domain.user.User;
import org.example.javaspringecommerce.dto.user.UserUpdateDTO;
import org.example.javaspringecommerce.exception.ResourceNotFoundException;
import org.example.javaspringecommerce.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    private UserRepository repository;
    private final PasswordEncoder passwordEncoder;


    public UserService(UserRepository repository,  PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    //==============================================================================================
    //                   Load the user when someone tries to log in
    //==============================================================================================

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail)
            throws UsernameNotFoundException {

        User user = repository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(() ->
                        new UsernameNotFoundException("Usuário não encontrado")
                );

        return user; // User IMPLEMENTA UserDetails
    }

    // ================== User Save ================================

    public User create(String username, String password, String email, Role role) {

        User user = new User();

        user.setUsername(username);
        user.setEmail(email);
        user.setPasswordHash(passwordEncoder.encode(password));
        user.setRole(role);


        return repository.save(user);
    }

    // ================= Read operation ==============================
    public List<User> findAll(){
        return repository.findAll();
    }

    //=====================================================================================
    //                       searching for a specific user
    //=====================================================================================

    public User findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    //=================== Update ====================================
    @Transactional
    public User updateUser(Long id, UserUpdateDTO dto) {

        User user = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));

        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());

        return user; // JPA faz o UPDATE automaticamente
    }

    //============================ delete =================================
    public void delete(Long id) {

        User user = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));

        repository.delete(user);
    }


}
