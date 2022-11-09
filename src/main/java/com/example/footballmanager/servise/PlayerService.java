package com.example.footballmanager.servise;

import com.example.footballmanager.entity.Player;

import java.util.List;

public interface PlayerService {

    public Player findByName(String name);

    public Player save(Player player);

    public List<Player> findAll();

    public Player update(Player player, String oldFirstName);

    public void delete(Player player);

    public List<Player> findByTransfer(boolean transfer);

    public Player findByFirstNameAndLastName(String playerFirstName, String playerLastName);
}
