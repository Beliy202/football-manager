package com.example.footballmanager.controller;

import com.example.footballmanager.entity.Player;
import com.example.footballmanager.entity.Team;
import com.example.footballmanager.entity.Transfer;
import com.example.footballmanager.servise.PlayerService;
import com.example.footballmanager.servise.TeamService;
import com.example.footballmanager.servise.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/transfer")
public class TransferController {
    @Autowired
    private PlayerService playerService;
    @Autowired
    private TeamService teamService;
    @Autowired
    private TransferService transferService;

    @GetMapping("/{transfer}")
    public ResponseEntity<List<Player>> findByTransfer(@PathVariable Boolean transfer) {
        List<Player> players = playerService.findByTransfer(transfer);

        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    @PostMapping("/saveTransfer")
    public ResponseEntity<Transfer> save(@RequestBody Transfer transfer){
        Transfer transfer1 = transferService.save(transfer);
        return new ResponseEntity<>(transfer1,HttpStatus.CREATED);
    }

    @GetMapping("/find/bind/{id}")
    public ResponseEntity<Transfer> findById(@PathVariable Long id){
        Transfer transfer = transferService.findById(id);
        return new ResponseEntity<>(transfer,HttpStatus.OK);
    }

    @GetMapping("/{transfer}/{id}")
    public ResponseEntity<Transfer> findByTeamTransfer(@PathVariable boolean transfer, @PathVariable Long id){
        Transfer transfer1 = transferService.findById(id);
        List<Team> teams = new ArrayList<>();
        teamService.findAll().forEach(teams::add);
        for (int i = 0; i < teams.size(); i++) {
            if(teams.get(i).getPlayers().get(i).isTransfer()==(transfer))
                transfer1.getResponseTeam().add(teams.get(i));
        }
        transferService.save(transfer1);
        return new ResponseEntity<>(transfer1,HttpStatus.OK);
    }






}
