package com.dictionaryapp.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Length(min = 3, max = 20)
    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Email
    @Column(unique = true, nullable = false)
    private String email;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Word> addedWords;

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Word> getAddedWords() {
        return addedWords;
    }

    public void setAddedWords(List<Word> addedWords) {
        this.addedWords = addedWords;
    }
}
