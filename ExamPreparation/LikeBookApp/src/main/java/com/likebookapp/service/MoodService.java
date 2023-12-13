package com.likebookapp.service;

import com.likebookapp.model.entity.Mood;
import com.likebookapp.model.enums.MoodNameEnum;
import com.likebookapp.repository.MoodRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MoodService {
    private final MoodRepository moodRepository;

    public MoodService(MoodRepository moodRepository) {
        this.moodRepository = moodRepository;
    }

    public void initMood() {
        boolean hasMood = moodRepository.count() > 0;
        if (!hasMood) {
            List<Mood> moods = new ArrayList<>();
            Arrays.stream(MoodNameEnum.values())
                    .forEach(moodNameEnum -> {
                        Mood mood = new Mood();
                        mood.setMoodName(moodNameEnum);
                        mood.setDescription(mood.getDescription());
                        moods.add(mood);
                    });
            moodRepository.saveAll(moods);
        }
    }
}
