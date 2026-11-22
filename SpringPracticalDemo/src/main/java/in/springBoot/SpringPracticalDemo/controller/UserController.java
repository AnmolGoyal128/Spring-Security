package in.springBoot.SpringPracticalDemo.controller;

import in.springBoot.SpringPracticalDemo.dto.UserRegisterRequestDto;
import in.springBoot.SpringPracticalDemo.dto.UserRegisterResponseDto;
import in.springBoot.SpringPracticalDemo.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final PasswordEncoder passwordEncoder;
    private final AuthService authService;

    @GetMapping

    public String getUser() {
        System.out.println(passwordEncoder.encode("password"));
        System.out.println(passwordEncoder.encode("password"));
        return "User data";
    }
    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponseDto> register(
            @RequestBody UserRegisterRequestDto userRegisterRequestDto) {

        UserRegisterResponseDto userRegisterResponseDto =
                authService.register(userRegisterRequestDto);

        return ResponseEntity.ok(userRegisterResponseDto);
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> login(
            @RequestBody UserRegisterRequestDto userRegisterRequestDto) {

        Boolean isLoggedIn =
                authService.login(userRegisterRequestDto);

        return ResponseEntity.ok(isLoggedIn);
    }

    @GetMapping("/token")
    public CsrfToken getToken(CsrfToken csrfToken) {
        return  csrfToken;
    }
}
