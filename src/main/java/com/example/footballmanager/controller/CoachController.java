package com.example.footballmanager.controller;

import com.example.footballmanager.dto.CoachDto;
import com.example.footballmanager.entity.Coach;
import com.example.footballmanager.entity.Team;
import com.example.footballmanager.servise.CoachService;
import com.example.footballmanager.servise.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@RestController
@RequestMapping("/coach")
public class CoachController {
    @Autowired
    private CoachService coachService;

    @Autowired
    private TeamService teamService;


    @GetMapping("/{coachFirstName}/{coachLastName}")
    public ResponseEntity<CoachDto> findByFirstNameAndLastName(@PathVariable String coachFirstName, @PathVariable String coachLastName) {
        Coach coach = coachService.findByCoachFirstNameAndCoachLastName(coachFirstName,coachLastName);
        return new ResponseEntity<>(CoachDto.builder()
                .coachFirstName(coach.getCoachFirstName())
                .coachAge(coach.getCoachAge())
                .build(), HttpStatus.OK);
    }



    @PostMapping("/saveCoach")
    public ResponseEntity<CoachDto> createCoach(@RequestBody Coach coach) {
        coachService.save(coach);
        return new ResponseEntity<>(CoachDto.builder()
                .coachFirstName(coach.getCoachFirstName())
                .coachLastName(coach.getCoachLastName())
                .coachAge(coach.getCoachAge())
                .build(),HttpStatus.OK);

    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Coach>> findAll() {
        List<Coach> coaches = new ArrayList<>();
        coachService.findAll().forEach(coaches::add);
        return new ResponseEntity<>(coaches, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{coachFirstName}/{coachLastName}")
    public ResponseEntity<HttpStatus> deleteCoachByCoachFirstName(@PathVariable String coachFirstName,@PathVariable String coachLastName){
        Coach coach = coachService.findByCoachFirstNameAndCoachLastName(coachFirstName,coachLastName);
        coachService.delete(coach);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @PostMapping("/{teamName}/{coachFirstName}/{coachLastName}")
    public ResponseEntity<Team> addCoach(@PathVariable String teamName,@PathVariable String coachFirstName, @PathVariable String coachLastName){

        Coach coach = coachService.findByCoachFirstNameAndCoachLastName(coachFirstName,coachLastName);
        Team team = teamService.findByNameTeam(teamName);
        team.setCoach(coach);
        Team save = teamService.save(team);
        return new ResponseEntity<>(save, HttpStatus.CREATED);

    }






}
