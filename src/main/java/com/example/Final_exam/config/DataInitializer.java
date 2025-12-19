package com.example.Final_exam.config;

import com.example.Final_exam.entity.Role;
import com.example.Final_exam.entity.User;
import com.example.Final_exam.repository.RoleRepository;
import com.example.Final_exam.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        Role adminRole = roleRepository.findByName("ROLE_ADMIN")
                .orElseGet(() -> roleRepository.save(Role.builder().name("ROLE_ADMIN").build()));

        Role userRole = roleRepository.findByName("ROLE_USER")
                .orElseGet(() -> roleRepository.save(Role.builder().name("ROLE_USER").build()));

        userRepository.findByUsername("admin").orElseGet(() ->
                userRepository.save(User.builder()
                        .username("admin")
                        .password(passwordEncoder.encode("admin123"))
                        .roles(Set.of(adminRole, userRole))
                        .build())
        );

        userRepository.findByUsername("user").orElseGet(() ->
                userRepository.save(User.builder()
                        .username("user")
                        .password(passwordEncoder.encode("user123"))
                        .roles(Set.of(userRole))
                        .build())
        );
    }
}

