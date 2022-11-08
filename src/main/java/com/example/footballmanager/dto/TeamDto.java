package com.example.footballmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class TeamDto {
    private String nameTeam;
    private String stadium;
    private int teamBudget;
}
