package com.example.footballmanager.controller;

import com.example.footballmanager.dto.PlayerDto;
import com.example.footballmanager.entity.Player;
import com.example.footballmanager.servise.PlayerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/{firstName}/{lastName}")
    public ResponseEntity<PlayerDto> findByFirstNameAndLastname(@PathVariable String firstName, @PathVariable String lastName) {
        log.info("Request method findByName, param{}", firstName);
        Player player = playerService.findByFirstNameAndLastName(firstName, lastName);
        return new ResponseEntity<>(PlayerDto.builder()
                .firstName(player.getFirstName())
                .lastName(player.getLastName())
                .age(player.getAge())
                .weight(player.getWeight())
                .growth(player.getGrowth())
                .position(player.getPosition())
                .transfer(player.isTransfer())
                .price(player.getPrice())
                .build(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<PlayerDto> createPlayer(@RequestBody Player player) {
        playerService.save(player);
        return new ResponseEntity<>(PlayerDto.builder()
                .firstName(player.getFirstName())
                .lastName(player.getLastName())
                .age(player.getAge())
                .weight(player.getWeight())
                .growth(player.getGrowth())
                .position(player.getPosition())
                .transfer(player.isTransfer())
                .price(player.getPrice())
                .build(), HttpStatus.CREATED);

    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Player>> findAll() {
        List<Player> players = new ArrayList<>();
        playerService.findAll().forEach(players::add);
        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    @PutMapping("/update/{oldFirstName}")
    public ResponseEntity<PlayerDto> update(@RequestBody Player player, @PathVariable String oldFirstName) {
        playerService.update(player, oldFirstName);
        return new ResponseEntity<>(PlayerDto.builder()
                .firstName(player.getFirstName())
                .lastName(player.getLastName())
                .age(player.getAge())
                .position(player.getPosition())
                .weight(player.getWeight())
                .growth(player.getGrowth())
                .transfer(player.isTransfer())
                .price(player.getPrice())
                .build(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{firstName}/{lastName}")//TODO:
    public ResponseEntity<HttpStatus> deletePlayerByName(@PathVariable String firstName, @PathVariable String lastName) {
        Player player = playerService.findByFirstNameAndLastName(firstName, lastName);
        playerService.delete(player);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

