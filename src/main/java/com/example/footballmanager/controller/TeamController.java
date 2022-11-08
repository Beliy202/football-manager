package com.example.footballmanager.controller;

import com.example.footballmanager.dto.AddTeamPlayerDto;
import com.example.footballmanager.dto.PlayerDto;
import com.example.footballmanager.dto.PlayerTransferDto;
import com.example.footballmanager.dto.TeamDto;
import com.example.footballmanager.entity.Coach;
import com.example.footballmanager.entity.Player;
import com.example.footballmanager.entity.Team;
import com.example.footballmanager.servise.CoachService;
import com.example.footballmanager.servise.PlayerService;
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
@RequestMapping("/team")
public class TeamController {
    @Autowired
    private TeamService teamService;
    @Autowired
    private PlayerService playerService;


    @PostMapping("/create")
    public ResponseEntity<TeamDto> createTeam(@RequestBody Team team) {
        teamService.save(team);
        return new ResponseEntity<>(TeamDto.builder()
                .nameTeam(team.getNameTeam())
                .stadium(team.getStadium())
                .teamBudget(team.getTeamBudget())
                .build(), HttpStatus.OK);
    }

    @GetMapping("/{nameTeam}")
    public ResponseEntity<TeamDto> findByName(@PathVariable String nameTeam) {
        Team team = teamService.findByNameTeam(nameTeam);
        return new ResponseEntity<>(TeamDto.builder()
                .nameTeam(team.getNameTeam())
                .stadium(team.getStadium())
                .teamBudget(team.getTeamBudget())
                .build(), HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Team>> findAll() {
        List<Team> teams = new ArrayList<>();
        teamService.findAll().forEach(teams::add);
        return new ResponseEntity<>(teams, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<HttpStatus> deleteTeamByName(@PathVariable String name) {
        Team team = teamService.findByNameTeam(name);
        teamService.delete(team);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



    @PostMapping("/addPlayer")
    public ResponseEntity<Team> addPlayer(@RequestBody AddTeamPlayerDto addTeamPlayerDto){

        Player player = playerService.findByFirstNameAndLastName(addTeamPlayerDto.getPlayerFirstName(),addTeamPlayerDto.getPlayerLastName());
        Team team = teamService.findByNameTeam(addTeamPlayerDto.getTeamName());
        team.getPlayers().add(player);
        Team save = teamService.save(team);
        return new ResponseEntity<>(save, HttpStatus.CREATED);

    }

    @PutMapping("/update/{firstName}/{lastName}")
    public ResponseEntity<HttpStatus> addPlayerOnTheTransfer(@RequestParam boolean transfer, @PathVariable String firstName,@PathVariable String lastName) {
        Player player = playerService.findByFirstNameAndLastName(firstName,lastName);
        player.setTransfer(transfer);
        playerService.save(player);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/transfer")
    public ResponseEntity<HttpStatus> transferPlayer(@RequestBody PlayerTransferDto playerTransferDto){
        Team fromTeam = teamService.findByNameTeam(playerTransferDto.getFromTeam());
        Team toTeam = teamService.findByNameTeam(playerTransferDto.getToTeam());
        Player transferPlayer = playerService.findByFirstNameAndLastName(playerTransferDto.getPlayerFirstName(),playerTransferDto.getPlayerLastName());
        teamService.transfer(fromTeam,toTeam,transferPlayer,playerTransferDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }




}