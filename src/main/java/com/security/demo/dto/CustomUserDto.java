package com.security.demo.dto;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomUserDto {

    private String username;
    private String email;

    public CustomUserDto(String username, String email) {
        this.username = username;
        this.email = email;
    }
}
