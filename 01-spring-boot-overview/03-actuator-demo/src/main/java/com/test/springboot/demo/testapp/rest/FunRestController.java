package com.test.springboot.demo.testapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    @GetMapping("/team")
    public String showTeam(){
        return coachName + " " + teamName;
    }

    //expose "/" that returns "hello world"

    @GetMapping("/")
    public String sayHello(){
        return "Hello World";
    }

    // expose a new endpoint for "workout"

    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "run a hard 5k";
    }

    @GetMapping("/fortune")
    public String getDailyFortune(){
        return "Today is your lucky day";
    }
}
