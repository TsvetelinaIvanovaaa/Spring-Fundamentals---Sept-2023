package com.dictionaryapp.init;

import com.dictionaryapp.model.entity.Language;
import com.dictionaryapp.model.enums.LanguageNameEnum;
import com.dictionaryapp.repo.LanguageRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class LanguagesInit implements CommandLineRunner {

    private final LanguageRepository languageRepository;

    public LanguagesInit(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public void run(String... args) {
        long count = languageRepository.count();

        if(count == 0) {
            List<Language> languages = new ArrayList<>();

            Arrays.stream(LanguageNameEnum.values())
                    .forEach(e -> {
                        Language language = new Language();
                        language.setLanguageName(e);
                        language.setDescription(e.getValue());
                        languageRepository.save(language);
                    });

        }
    }
//    public Language findByLanguageNameEnum(LanguageNameEnum language) {
//        return languageRepository.findByName(language).orElse(null);
//    }

}