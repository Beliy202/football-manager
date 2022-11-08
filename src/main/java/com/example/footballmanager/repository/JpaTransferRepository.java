package com.example.footballmanager.repository;

import com.example.footballmanager.entity.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaTransferRepository extends JpaRepository<Transfer, Long> {

}
