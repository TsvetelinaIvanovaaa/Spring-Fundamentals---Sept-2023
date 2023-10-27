package com.dictionaryapp.model.entity;

import com.dictionaryapp.model.enums.LanguageNameEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "languages")
public class Language extends BaseEntity{

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private LanguageNameEnum languageName;

    @Column(nullable = false)
    private String description;

    public Language() {
    }

    public LanguageNameEnum getLanguageName() {
        return languageName;
    }

    public void setLanguageName(LanguageNameEnum languageName) {
        this.languageName = languageName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
