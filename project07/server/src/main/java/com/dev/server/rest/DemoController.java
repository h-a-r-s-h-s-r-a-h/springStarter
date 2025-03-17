package com.dev.server.rest;

import com.dev.server.common.Coach;
import com.dev.server.common.CricketCoach;
import com.dev.server.common.FootballCoach;
import com.dev.server.common.SoccerCoach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach cricketCoach;
    private Coach footballCoach;
    private Coach soccerCoach;

    @Autowired
    public DemoController(CricketCoach cricketCoach, FootballCoach footballCoach, SoccerCoach soccerCoach) {
        this.cricketCoach = cricketCoach;
        this.footballCoach = footballCoach;
        this.soccerCoach = soccerCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return cricketCoach.getDailyWorkout();
    }

    @GetMapping("/football")
    public String getFootballWorkout() {
        return footballCoach.getDailyWorkout();
    }

    @GetMapping("/soccer")
    public String getSoccerWorkout() {
        return soccerCoach.getDailyWorkout();
    }

}
