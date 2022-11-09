package com.example.footballmanager.repository;

import com.example.footballmanager.entity.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaCoachRepository extends JpaRepository<Coach, Long> {

    Optional<Coach> findByCoachFirstName(String coachFirstName);

    Optional<Coach> findByCoachFirstNameAndCoachLastName(String coachFirstName, String coachLastName);
}
