package com.example.footballmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CoachDto {

    private String coachFirstName;
    private String coachLastName;
    private String coachAge;
}
