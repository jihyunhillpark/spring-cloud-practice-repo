package com.example.userservice.service;

import com.example.userservice.service.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface CustomeUserDetailService extends UserDetailsService {
    UserDto getUserDetailsByEmail(String email);
}
