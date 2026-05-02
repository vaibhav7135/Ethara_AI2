package com.taskmanager.demo.controller; import org.springframework.security.crypto.password.PasswordEncoder; import org.springframework.web.bind.annotation.PostMapping; import org.springframework.web.bind.annotation.RequestBody; import org.springframework.web.bind.annotation.RequestMapping; import org.springframework.web.bind.annotation.RestController; import com.taskmanager.demo.dto.AuthRequest; import com.taskmanager.demo.dto.RegisterRequest; import com.taskmanager.demo.entity.User; import com.taskmanager.demo.enums.Role; import com.taskmanager.demo.repository.UserRepository;
import com.taskmanager.demo.util.JwtUtil;

import lombok.RequiredArgsConstructor;
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    
    public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder,JwtUtil jwtUtil) { 
    	this.userRepository = userRepository ; 
    	this.passwordEncoder = passwordEncoder; 
    	this.jwtUtil=jwtUtil;
    	}

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        // 🔥 ROLE FROM REQUEST
        try {
            user.setRole(Role.valueOf(request.getRole().toUpperCase()));
        } catch (Exception e) {
            user.setRole(Role.MEMBER); // default fallback
        }

        userRepository.save(user);
        return "User registered successfully";
    }

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {

            return jwtUtil.generateToken(user.getEmail(), user.getRole().name());
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }
}