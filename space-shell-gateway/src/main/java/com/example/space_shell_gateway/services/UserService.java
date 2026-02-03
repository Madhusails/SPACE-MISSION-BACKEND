package com.example.space_shell_gateway.services;

import com.example.space_shell_gateway.dto.UserRequest;
import com.example.space_shell_gateway.entity.Users;
import com.example.space_shell_gateway.mapper.UserMapper;
import com.example.space_shell_gateway.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public Users createUser(UserRequest user) {
        Users mappedUser = userMapper.toEntity(user);
        return userRepository.save(mappedUser);
    }
}
