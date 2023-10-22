package com.example.userservice.service.dto;

import com.example.userservice.controller.vo.ResponseOrder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class UserDto {
    private String email;
    private String name;
    private String pwd;
    private String userId;
    private Date createdAt;
    private String encryptedPwd;
    private List<ResponseOrder> orders;
}
