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
@Table(name = "players")

public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String firstName;
    private String lastName;
    private String age;
    private String weight;
    private String growth;
    private String position;
    private boolean transfer;
    private int price;




}
