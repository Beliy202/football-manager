package com.example.footballmanager.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "coach")

public class Coach {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String coachFirstName;
    private String coachLastName;
    private String coachAge;


}
