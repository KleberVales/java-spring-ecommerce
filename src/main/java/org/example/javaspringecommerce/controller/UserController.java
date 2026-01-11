package org.example.javaspringecommerce.controller;

import org.example.javaspringecommerce.domain.user.User;
import org.example.javaspringecommerce.dto.user.UserRequestDTO;
import org.example.javaspringecommerce.dto.user.UserResponseDTO;
import org.example.javaspringecommerce.dto.user.UserUpdateDTO;
import org.example.javaspringecommerce.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public UserResponseDTO registerUser(@RequestBody UserRequestDTO userRequestDTO) {

        User user = userService.create(userRequestDTO.getUsername(),
                userRequestDTO.getEmail(), userRequestDTO.getPasswordHash(), userRequestDTO.getRole());

        UserResponseDTO userResponseDTO = new UserResponseDTO();

        userResponseDTO.setUsername(user.getUsername());
        userResponseDTO.setId(user.getId());


        return userResponseDTO;
    }

    //=============================== Operation read =========================================
    @GetMapping
    public List<UserResponseDTO> findAll() {
        return userService.findAll().stream()
                .map(user -> new UserResponseDTO(user.getId(), user.getUsername(), user.getEmail(),
                        user.getPasswordHash()))
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> findById(@PathVariable Long id) {

        User user = userService.findById(id);

        UserResponseDTO dto = new UserResponseDTO(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPasswordHash()
        );

        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> update(
            @PathVariable Long id,
            @RequestBody UserUpdateDTO dto) {

        User updated = userService.updateUser(id, dto);

        UserResponseDTO response = new UserResponseDTO(
                updated.getId(),
                updated.getUsername(),
                updated.getEmail()
        );

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id) {
        userService.delete(id);
    }

}
