package com.example.footballmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SaveUserDto {
    String username;
    String password;
    String name;
}
