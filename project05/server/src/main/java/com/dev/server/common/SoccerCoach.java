package com.dev.server.common;

import org.springframework.stereotype.Component;

@Component
public class SoccerCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practice passing for 20 minutes!";
    }
}
