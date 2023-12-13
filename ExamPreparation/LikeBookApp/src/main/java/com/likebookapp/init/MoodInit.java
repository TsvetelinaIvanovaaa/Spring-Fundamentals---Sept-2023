package com.likebookapp.init;

import com.likebookapp.service.MoodService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MoodInit implements CommandLineRunner {

    private final MoodService moodService;

    public MoodInit(MoodService moodService) {
        this.moodService = moodService;
    }
    @Override
    public void run(String... args) throws Exception {
        moodService.initMood();
    }
}
