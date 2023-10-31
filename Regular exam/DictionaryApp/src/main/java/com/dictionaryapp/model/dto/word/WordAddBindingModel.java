package com.dictionaryapp.model.dto.word;

import com.dictionaryapp.model.anotation.StringDatePastOrPresent;
import com.dictionaryapp.model.enums.LanguageNameEnum;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

public class WordAddBindingModel {

    @NotNull
    @Size(min = 2, max = 40, message = "The term length must be between 2 and 40 characters!")
    private String term;

    @NotNull
    @Size(min = 2, max = 80, message = "The translation must be between 2 and 80 characters!")
    private String translation;

    @NotNull
    @Size(min = 2, max = 200, message = "The example must be between 2 and 200 characters!")
    private String example;

    @StringDatePastOrPresent(message = "The input date must be in past or present!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String inputDate;

    @NotNull(message = "You must select language!")
    private LanguageNameEnum languageName;

    public WordAddBindingModel() {
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public String getInputDate() {
        return inputDate;
    }

    public void setInputDate(String inputDate) {
        this.inputDate = inputDate;
    }

    public LanguageNameEnum getLanguage() {
        return languageName;
    }

    public void setLanguage(LanguageNameEnum language) {
        this.languageName = language;
    }
}
