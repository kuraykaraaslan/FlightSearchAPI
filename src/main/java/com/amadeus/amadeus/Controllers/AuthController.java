package com.amadeus.amadeus.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amadeus.amadeus.Models.User;
import com.amadeus.amadeus.Repository.UserRepository;
import com.amadeus.amadeus.Requests.LoginRequest;
import com.amadeus.amadeus.Requests.SignUpRequest;



@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<String> authenticateUser(@RequestBody LoginRequest login) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>("User login successfully!...", HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUpRequest SignUp) {
        // checking for username exists in a database
        if (userRepository.findByUsername(SignUp.getUsername()).isPresent()) {
            return new ResponseEntity<>("Username is already exist!", HttpStatus.BAD_REQUEST);
        }
        // checking for email exists in a database
        if (userRepository.existsByEmail(SignUp.getEmail())) {
            return new ResponseEntity<>("Email is already exist!", HttpStatus.BAD_REQUEST);
        }
        // creating user object
        User user = new User();
        user.setName(SignUp.getName());
        user.setUserName(SignUp.getUsername());
        user.setEmail(SignUp.getEmail());
        user.setPassword(passwordEncoder.encode(SignUp.getPassword()));
        String role = "ROLE_USER";
        // roles to list
        List<String> roles = new ArrayList<>();
        roles.add(role);
        user.setRoles(roles);
        userRepository.save(user);
        return new ResponseEntity<>("User is registered successfully!", HttpStatus.OK);
    }
}