package in.springBoot.SpringPracticalDemo.service;

import in.springBoot.SpringPracticalDemo.dto.UserRegisterRequestDto;
import in.springBoot.SpringPracticalDemo.dto.UserRegisterResponseDto;
import in.springBoot.SpringPracticalDemo.entity.User;
import in.springBoot.SpringPracticalDemo.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor

public class AuthService {

    private  final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

//    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//    }

    public UserRegisterResponseDto register(
            UserRegisterRequestDto userRegisterRequestDto) {

        User user = new User();
        user.setName(userRegisterRequestDto.getUsername());
        //user.setPassword(userRegisterRequestDto.getPassword()); --> It will store raw password

        String encodedPassword =
                passwordEncoder.encode(userRegisterRequestDto.getPassword());
        user.setPassword(encodedPassword);
        user.setEnabled(true);

        userRepository.save(user);

        UserRegisterResponseDto userRegisterResponseDto =
                new UserRegisterResponseDto();

        userRegisterResponseDto.setUsername(user.getName());
        userRegisterResponseDto.setMessage("User Saved Successfully");
        return  userRegisterResponseDto;
    }

    public Boolean login(
            UserRegisterRequestDto userRegisterRequestDto) {
        Optional<User> userOptional = userRepository.findByUsername(
                userRegisterRequestDto.getUsername()
        );

        User user = userOptional.get();

        String encodedPassword = user.getPassword();

        return passwordEncoder.matches(
                userRegisterRequestDto.getPassword(),
                encodedPassword);
    }
}
