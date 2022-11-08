package com.example.footballmanager.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Entity
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nameTeam;
    private String stadium;
    private int teamBudget;
    @OneToOne(fetch = FetchType.EAGER)
    private Coach coach;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Player> players;

}
