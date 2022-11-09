package com.example.footballmanager.servise.impl;

import com.example.footballmanager.entity.Coach;
import com.example.footballmanager.exception.ResourceNotFoundException;
import com.example.footballmanager.repository.JpaCoachRepository;
import com.example.footballmanager.servise.CoachService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CoachServiceImpl implements CoachService {

    @Autowired
    private JpaCoachRepository jpaCoachRepository;

    @Override
    public Coach save(Coach coach) {
        return jpaCoachRepository.save(coach);
    }

    @Override
    public List<Coach> findAll() {
        return jpaCoachRepository.findAll();
    }

    @Override
    public void delete(Coach coach) {
        jpaCoachRepository.delete(coach);
    }

    @Override
    public Coach findByCoachFirstNameAndCoachLastName(String coachFirstName, String coachLastName) {
        Coach coach = jpaCoachRepository.findByCoachFirstNameAndCoachLastName(coachFirstName, coachLastName).orElseThrow(() ->
                new ResourceNotFoundException(String.format("Not found coach %s %s", coachFirstName, coachLastName)));
        return coach;
    }
}
