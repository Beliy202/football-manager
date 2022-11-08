package com.example.footballmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class PlayerDto {
    private String firstName;
    private String lastName;
    private String age;
    private String weight;
    private String growth;
    private String position;
    private boolean transfer;
    private int price;


}



