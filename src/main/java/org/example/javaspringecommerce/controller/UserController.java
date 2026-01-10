package org.example.javaspringecommerce.controller;

import org.example.javaspringecommerce.domain.user.User;
import org.example.javaspringecommerce.dto.user.UserRequestDTO;
import org.example.javaspringecommerce.dto.user.UserResponseDTO;
import org.example.javaspringecommerce.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
                userRequestDTO.getEmail(), userRequestDTO.getPasswordHash());

        UserResponseDTO userResponseDTO = new UserResponseDTO();

        userResponseDTO.setUsername(user.getUsername());
        userResponseDTO.setId(user.getId());


        return userResponseDTO;
    }

}
