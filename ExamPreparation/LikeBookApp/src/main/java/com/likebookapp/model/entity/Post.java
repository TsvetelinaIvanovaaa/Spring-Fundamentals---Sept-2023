package com.likebookapp.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post extends BaseEntity{

    @Column(nullable = false)
    private String content;


    @ManyToOne
    private User user;

    @Column(nullable = false)
    @OneToMany(fetch = FetchType.EAGER)
    private List<User> userLikes;

    @ManyToOne
    private Mood mood;

    public Post() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUserLikes() {
        return userLikes;
    }

    public void setUserLikes(List<User> userLikes) {
        this.userLikes = userLikes;
    }

    public Mood getMood() {
        return mood;
    }

    public void setMood(Mood mood) {
        this.mood = mood;
    }
}
