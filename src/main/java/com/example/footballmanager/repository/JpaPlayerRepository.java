package com.example.footballmanager.repository;

import com.example.footballmanager.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JpaPlayerRepository extends JpaRepository<Player,Long> {

    Optional<Player> findByFirstName(String name);

    Optional<List<Player>> findByTransfer(boolean transfer);

    Optional<Player> findByFirstNameAndLastName(String firstName, String lastName);
}
