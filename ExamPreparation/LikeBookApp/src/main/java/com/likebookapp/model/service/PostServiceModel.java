package com.likebookapp.model.service;

import com.likebookapp.model.entity.User;
import com.likebookapp.model.enums.MoodNameEnum;

import java.util.List;

public class PostServiceModel {

    private String content;

    private MoodNameEnum moodName;

    private List<User> userLikes;

    public PostServiceModel() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MoodNameEnum getMoodName() {
        return moodName;
    }

    public void setMoodName(MoodNameEnum moodName) {
        this.moodName = moodName;
    }

    public List<User> getUserLikes() {
        return userLikes;
    }

    public void setUserLikes(List<User> userLikes) {
        this.userLikes = userLikes;
    }
}
