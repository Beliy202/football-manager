package com.example.footballmanager.repository;

import com.example.footballmanager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaUserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUsername(String username);
}
