package com.example.footballmanager.servise;

import com.example.footballmanager.entity.Coach;

import java.util.List;

public interface CoachService {

    public Coach save(Coach coach);

    public List<Coach> findAll();

    public void delete(Coach coach);

    public Coach findByCoachFirstNameAndCoachLastName(String coachFirstName, String coachLastName);
}
