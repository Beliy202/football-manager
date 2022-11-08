package com.example.footballmanager.dto;

import lombok.Data;

@Data
public class PlayerTransferDto {

    String playerFirstName;
    String playerLastName;
    String fromTeam;
    String toTeam;
    int pricePlayer;

}
