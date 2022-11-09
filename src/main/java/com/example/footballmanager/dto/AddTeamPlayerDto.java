package com.example.footballmanager.dto;

import lombok.Data;

@Data
public class AddTeamPlayerDto {

    private String playerFirstName;
    private String playerLastName;
    private String teamName;
}
