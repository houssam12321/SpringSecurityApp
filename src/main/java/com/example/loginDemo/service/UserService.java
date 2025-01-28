package com.example.loginDemo.service;



import com.example.loginDemo.model.Role;
import com.example.loginDemo.model.User;
import com.example.loginDemo.repository.RoleRepository;
import com.example.loginDemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerUser(User user) {
        // Encode the password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Assign default role (ROLE_USER)
        Role userRole = roleRepository.findByName("ROLE_USER");
        user.setRoles(Collections.singletonList(userRole));

        userRepository.save(user);
    }
}