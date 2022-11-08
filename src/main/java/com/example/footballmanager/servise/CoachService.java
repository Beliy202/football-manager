package com.example.footballmanager.servise;

import com.example.footballmanager.entity.Coach;
import com.example.footballmanager.exception.ResourceNotFoundException;
import com.example.footballmanager.repository.JpaCoachRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CoachService {
    @Autowired
    private JpaCoachRepository jpaCoachRepository;



    public Coach save(Coach coach) {
        return jpaCoachRepository.save(coach);
    }

    public List<Coach> findAll() {
        return jpaCoachRepository.findAll();
    }

    public void delete(Coach coach) {
        jpaCoachRepository.delete(coach);
    }

    public Coach findByCoachFirstNameAndCoachLastName(String coachFirstName, String coachLastName) {
        Coach coach =  jpaCoachRepository.findByCoachFirstNameAndCoachLastName(coachFirstName,coachLastName).orElseThrow(()->
                new ResourceNotFoundException(String.format("Not found coach %s %s", coachFirstName,coachLastName)));
        return coach;
    }
}
