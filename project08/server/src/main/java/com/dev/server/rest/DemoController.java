package com.dev.server.rest;

import com.dev.server.common.Coach;
import com.dev.server.common.CricketCoach;
import com.dev.server.common.FootballCoach;
import com.dev.server.common.SoccerCoach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;


    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach theCoach) {
        this.myCoach = theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

}
