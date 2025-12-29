package com.blogapp.backend.controller;

import com.blogapp.backend.model.User;
import com.blogapp.backend.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    private final UserRepository repo;

    public AuthController(UserRepository repo) {
        this.repo = repo;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody User user) {
        if (repo.findByEmail(user.getEmail()).isPresent())
            return ResponseEntity.status(409).body("Email exists");

        if (repo.findByUsername(user.getUsername()).isPresent())
            return ResponseEntity.status(409).body("Username exists");

        repo.save(user);
        return ResponseEntity.ok("Created");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        Optional<User> found = repo.findByEmail(user.getEmail());
        if (found.isEmpty()) return ResponseEntity.status(401).body("Invalid");

        if (!found.get().getPassword().equals(user.getPassword()))
            return ResponseEntity.status(401).body("Invalid");

        return ResponseEntity.ok(new LoginResponse(found.get().getUsername()));
    }

    record LoginResponse(String username) {}
}
