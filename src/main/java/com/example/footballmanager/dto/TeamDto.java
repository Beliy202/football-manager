package com.example.footballmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class TeamDto {

    private String nameTeam;
    private String stadium;
    private int teamBudget;
}
