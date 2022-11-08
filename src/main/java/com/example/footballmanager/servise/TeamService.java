package com.example.footballmanager.servise;

import com.example.footballmanager.dto.PlayerTransferDto;
import com.example.footballmanager.entity.Player;
import com.example.footballmanager.entity.Team;
import com.example.footballmanager.exception.ResourceNotFoundException;
import com.example.footballmanager.repository.JpaTeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamService {
    @Autowired
    private  JpaTeamRepository jpaTeamRepository;

    public Team save(Team team) {
        return jpaTeamRepository.save(team);
    }

    public Team findByNameTeam(String nameTeam) {
        return jpaTeamRepository.findByNameTeam(nameTeam).orElseThrow(()->
                new ResourceNotFoundException(String.format("Not found player %s", nameTeam)));
    }


    public List<Team> findAll() {
        return jpaTeamRepository.findAll();
    }

    public void delete(Team team) {
        jpaTeamRepository.delete(team);
    }

    public void transfer(Team fromTeam, Team toTeam, Player transferPlayer, PlayerTransferDto playerTransferDto) {
        fromTeam.setTeamBudget(fromTeam.getTeamBudget()+playerTransferDto.getPricePlayer());
        toTeam.setTeamBudget(toTeam.getTeamBudget()-playerTransferDto.getPricePlayer());
        fromTeam.getPlayers().remove(transferPlayer);
        toTeam.getPlayers().add(transferPlayer);
        jpaTeamRepository.save(fromTeam);
        jpaTeamRepository.save(toTeam);
    }
}
