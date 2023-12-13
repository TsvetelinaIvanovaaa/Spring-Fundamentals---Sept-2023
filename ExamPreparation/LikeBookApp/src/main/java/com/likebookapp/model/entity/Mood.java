package com.likebookapp.model.entity;

import com.likebookapp.model.enums.MoodNameEnum;

import javax.persistence.*;

@Entity
@Table(name = "moods")
public class Mood extends BaseEntity{

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private MoodNameEnum moodName;

    @Column(nullable = true)
    private String description;

    public Mood() {
    }

    public MoodNameEnum getMoodName() {
        return moodName;
    }

    public void setMoodName(MoodNameEnum moodName) {
        this.moodName = moodName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
