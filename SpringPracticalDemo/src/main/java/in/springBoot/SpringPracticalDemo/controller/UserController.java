package in.springBoot.SpringPracticalDemo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final PasswordEncoder passwordEncoder;

    @GetMapping

    public String getUser() {
        System.out.println(passwordEncoder.encode("password"));
        System.out.println(passwordEncoder.encode("password"));
        return "User data";
    }
    @PostMapping
    public ResponseEntity<String> createUser() {
        System.out.println(passwordEncoder.encode("password"));
        System.out.println(passwordEncoder.encode("password"));
        return ResponseEntity.ok("User created successfully");
    }
}
