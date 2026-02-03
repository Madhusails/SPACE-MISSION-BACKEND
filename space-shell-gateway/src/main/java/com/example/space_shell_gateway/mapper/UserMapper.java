package com.example.space_shell_gateway.mapper;

import com.example.space_shell_gateway.dto.UserRequest;
import com.example.space_shell_gateway.entity.Users;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    Users toEntity(UserRequest request);

    UserRequest toDto(Users user);
}
