package com.dev.server.rest;

import com.dev.server.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;
    private Coach anotherCoach;

    @Autowired
    public DemoController(@Qualifier("trackCoach") Coach theCoach, @Qualifier("cricketCoach") Coach myMricketCoach) {
        myCoach = theCoach;
        anotherCoach = myMricketCoach;
    }

    @GetMapping("/")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/cricket")
    public String getCricketWorkout() {
        return anotherCoach.getDailyWorkout();
    }
}
