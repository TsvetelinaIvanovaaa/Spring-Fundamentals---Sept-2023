package com.likebookapp.model.entity;

import com.likebookapp.model.enums.MoodName;
import org.hibernate.annotations.Columns;

import javax.persistence.*;

@Entity
@Table(name = "moods")
public class Mood extends BaseEntity{

    @Column(unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private MoodName moodName;

    @Column(columnDefinition = "TEXT")
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
