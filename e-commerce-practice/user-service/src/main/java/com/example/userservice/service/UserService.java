package com.example.userservice.service;

import com.example.userservice.service.dto.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDto);
}
