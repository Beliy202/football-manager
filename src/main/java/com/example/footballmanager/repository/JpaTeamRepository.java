package com.example.footballmanager.repository;

import com.example.footballmanager.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaTeamRepository extends JpaRepository<Team, Long> {

    Optional<Team> findByNameTeam(String nameTeam);
}
