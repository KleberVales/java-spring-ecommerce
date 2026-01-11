package org.example.javaspringecommerce.controller;

import org.example.javaspringecommerce.dto.auth.AuthRequestDTO;
import org.example.javaspringecommerce.dto.auth.AuthResponseDTO;
import org.example.javaspringecommerce.repository.UserRepository;
import org.example.javaspringecommerce.security.JwtTokenProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository repo;
    private final PasswordEncoder encoder;
    private final JwtTokenProvider jwt;

    public AuthController(UserRepository repo, PasswordEncoder encoder, JwtTokenProvider jwt) {
        this.repo = repo; this.encoder = encoder; this.jwt = jwt;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody AuthRequestDTO req) {
        // implementar autenticação manual simples: buscar user por username/email e comparar password
        var userOpt = repo.findByUsernameOrEmail(req.usernameOrEmail(), req.usernameOrEmail());
        if (userOpt.isEmpty()) {
            return ResponseEntity.status(401).build();
        }
        var user = userOpt.get();
        if (!encoder.matches(req.password(), user.getPassword())) {
            return ResponseEntity.status(401).build();
        }
        Set<String> roles = Set.of(user.getRole().name());
        String token = jwt.createToken(user.getUsername(), roles);

        return ResponseEntity.ok(new AuthResponseDTO(token, "Bearer"));

    }


}
