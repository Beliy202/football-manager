package com.example.footballmanager.servise;

import com.example.footballmanager.entity.Player;
import com.example.footballmanager.exception.ResourceNotFoundException;
import com.example.footballmanager.repository.JpaPlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerService {
    @Autowired
    private  JpaPlayerRepository jpaPlayerRepository;


    public Player findByName(String name) {
        return jpaPlayerRepository.findByFirstName(name).orElseThrow(()->
                new ResourceNotFoundException(String.format("Not found player %s", name)));
    }

    public Player save(Player player) {
        return jpaPlayerRepository.save(player);
    }

    public List<Player> findAll() {
        return jpaPlayerRepository.findAll();
    }

    public Player update(Player player, String oldFirstName){
        Player player1 = jpaPlayerRepository.findByFirstName(oldFirstName).orElseThrow(()->
                new ResourceNotFoundException(String.format("Not found player %s", oldFirstName)));
        player1.setFirstName(player.getFirstName());
        player1.setLastName(player.getLastName());
        player1.setAge(player.getAge());
        player1.setWeight(player.getWeight());
        player1.setGrowth(player.getGrowth());
        player1.setPosition(player.getPosition());
        player1.setTransfer(player.isTransfer());

        return   jpaPlayerRepository.save(player1);

    }

    public void delete(Player player) {
        jpaPlayerRepository.delete(player);
    }

    public List<Player> findByTransfer(boolean transfer) {
        return jpaPlayerRepository.findByTransfer(transfer).orElseThrow(()->
                new ResourceNotFoundException(String.format("Not found transfer %s", transfer)));
    }


    public Player findByFirstNameAndLastName(String playerFirstName, String playerLastName) {
        return jpaPlayerRepository.findByFirstNameAndLastName(playerFirstName,playerLastName).orElseThrow(()->
                new ResourceNotFoundException(String.format("Not found player by %s %s", playerFirstName,playerLastName)));
    }
}
