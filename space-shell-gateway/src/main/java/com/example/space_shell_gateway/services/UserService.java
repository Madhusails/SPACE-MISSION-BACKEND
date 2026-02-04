package com.example.space_shell_gateway.services;

import com.example.space_shell_gateway.dto.UserRequest;
import com.example.space_shell_gateway.entity.Users;
import com.example.space_shell_gateway.mapper.UserMapper;
import com.example.space_shell_gateway.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public Users createUser(UserRequest user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("ROLE_" + user.getRole().toUpperCase());
        Users mappedUser = userMapper.toEntity(user);

        return userRepository.save(mappedUser);
    }
}
