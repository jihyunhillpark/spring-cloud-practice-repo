package com.example.userservice.controller.vo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestUser {
    @NotNull(message = "Email은 null이면 안 됩니다.")
    @Size(min = 2, message = "Email의 길이는 2글자 이상이어야합니다.")
    @Email
    private String email;
    @NotNull(message = "Name은 null이면 안 됩니다.")
    @Size(min = 2, message = "Name의 길이는 2글자 이상이어야합니다.")
    private String name;

    @NotNull(message = "Password는 null이면 안 됩니다.")
    @Size(min = 8, message = "Password의 길이는 8글자 이상이어야합니다.")
    private String pwd;
}
