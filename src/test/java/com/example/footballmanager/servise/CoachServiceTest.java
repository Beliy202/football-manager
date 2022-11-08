package com.example.footballmanager.servise;

import com.example.footballmanager.entity.Coach;
import com.example.footballmanager.repository.JpaCoachRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
class CoachServiceTest {

    @InjectMocks
    private CoachService coachService;
    @Mock
    private JpaCoachRepository jpaCoachRepository;
    private static Coach coach;

    @BeforeAll
    static void setUp(){
        coach = Coach.builder()
                .id(1L)
                .coachFirstName("vasya")
                .coachLastName("ivanov")
                .coachAge("12")
                .build();
    }

    @Test
    void findByCoachFirstNameAndCoachLastName() {
        Mockito.when(jpaCoachRepository.findByCoachFirstNameAndCoachLastName(any(),any())).thenReturn(Optional.ofNullable(coach));

        Coach coachFirstNameAndCoachLastName = coachService.findByCoachFirstNameAndCoachLastName("vasya","ivanov");

        Assertions.assertEquals(coachFirstNameAndCoachLastName.getId(), coach.getId());
        Assertions.assertEquals(coachFirstNameAndCoachLastName.getCoachFirstName(), coach.getCoachFirstName());
    }

//    @Test
//    void findByCoachFirstNameAndCoachLastNameNegative() {
//        Mockito.when(jpaCoachRepository.findByCoachFirstNameAndCoachLastName("vasya","ivanov")).thenReturn(Optional.empty());
//        Coach coachFirstNameAndCoachLastNam = coachService.findByCoachFirstNameAndCoachLastName("vasya","ivanov");
//
//        Assertions.assertNull(coachFirstNameAndCoachLastNam);
//    }

    @Test
    void save() {
    }

    @Test
    void findAll() {
    }

    @Test
    void delete() {
    }
}