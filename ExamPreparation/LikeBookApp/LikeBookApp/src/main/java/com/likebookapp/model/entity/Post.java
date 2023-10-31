package com.likebookapp.model.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "posts")
public class Post extends BaseEntity{

    @Column(nullable = false, columnDefinition = "TEXT")
    @Length(min = 2, max = 150)
    private String content;

    @Column(nullable = false)


//    @NotNull
//    private User user;
//
//    @ManyToMany
//    private List<User> usersLikes;

    @ManyToOne
    @NotNull
    private Mood mood;

    public Post() {
    }
}
