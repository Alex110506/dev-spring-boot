package com.test.springcoredemo.common;

public class SwimCoach implements Coach{

    public SwimCoach(){
        System.out.println("in constructor");
    }

    @Override
    public String getDailyWorkout() {
        return "";
    }
}
