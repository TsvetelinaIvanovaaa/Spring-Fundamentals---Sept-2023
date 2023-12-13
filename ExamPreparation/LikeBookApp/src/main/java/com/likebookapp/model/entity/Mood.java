package com.likebookapp.model.entity;

import com.likebookapp.model.enums.MoodName;

import javax.persistence.*;

@Entity
@Table(name = "moods")
public class Mood extends BaseEntity{

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private MoodName moodName;

    @Column(nullable = false)
    private String description;

    public Mood() {
    }

    public MoodName getMoodName() {
        return moodName;
    }

    public void setMoodName(MoodName moodName) {
        this.moodName = moodName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
