package com.dev.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach cricketCoach;
    private Coach footballCoach;

    @Autowired
    public DemoController(CricketCoach cricketCoach, FootballCoach footballCoach) {
        this.cricketCoach = cricketCoach;
        this.footballCoach = footballCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return cricketCoach.getDailyWorkout();
    }

    @GetMapping("/football")
    public String getFootballWorkout() {
        return footballCoach.getDailyWorkout();
    }

}
