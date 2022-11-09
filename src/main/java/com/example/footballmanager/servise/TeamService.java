package com.example.footballmanager.servise;

import com.example.footballmanager.dto.PlayerTransferDto;
import com.example.footballmanager.entity.Player;
import com.example.footballmanager.entity.Team;

import java.util.List;

public interface TeamService {

    public Team save(Team team);

    public Team findByNameTeam(String nameTeam);

    public List<Team> findAll();

    public void delete(Team team);

    public void transfer(Team fromTeam, Team toTeam, Player transferPlayer, PlayerTransferDto playerTransferDto);
}
