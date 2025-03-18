package com.dev.server.common;

import org.springframework.stereotype.Component;

@Component
public class BadmintonCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practice badminton for 15 minutes!";
    }

}
