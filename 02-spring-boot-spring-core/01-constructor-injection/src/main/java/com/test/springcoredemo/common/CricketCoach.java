package com.test.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

//    @PostConstruct
//    public void doMyStart(){
//        System.out.println("we are in start "+getClass().getSimpleName());
//    }
//
//    @PreDestroy
//    public void doMyCleanup(){
//        System.out.println("we are in cleanup "+getClass().getSimpleName());
//    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes !!";
    }
}
