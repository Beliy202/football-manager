package com.example.footballmanager.dto;

import lombok.Data;

@Data
public class PlayerTransferDto {

    private String playerFirstName;
    private String playerLastName;
    private String fromTeam;
    private String toTeam;
    private int pricePlayer;
}
