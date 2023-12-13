package com.dictionaryapp.service;

import com.dictionaryapp.model.entity.Language;
import com.dictionaryapp.model.enums.LanguageNameEnum;
import com.dictionaryapp.repo.LanguageRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class LanguageService {

    private final LanguageRepository languageRepository;

    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    public void initLanguage() {
        if (this.languageRepository.count() != 0) {
            return;
        }

        Arrays.stream(LanguageNameEnum.values())
                .forEach(e -> {
                    Language language = new Language();
                    language.setName(e);
                    language.setDescription(e.getValue());

                    this.languageRepository.save(language);
                });
    }

    public Language findByLanguageNameEnum(LanguageNameEnum language) {
        return languageRepository.findByName(language).orElse(null);
    }
}