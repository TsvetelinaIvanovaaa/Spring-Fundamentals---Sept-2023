package com.dictionaryapp.service.impl;

import com.dictionaryapp.model.dto.word.WordAddBindingModel;
import com.dictionaryapp.model.entity.Language;
import com.dictionaryapp.model.entity.Word;
import com.dictionaryapp.repo.LanguageRepository;
import com.dictionaryapp.repo.WordRepository;
import com.dictionaryapp.service.WordService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class WordServiceImpl implements WordService {

    private final WordRepository wordRepository;
    private final LanguageRepository languageRepository;

    public WordServiceImpl(WordRepository wordRepository, LanguageRepository languageRepository) {
        this.wordRepository = wordRepository;
        this.languageRepository = languageRepository;
    }

    @Override
    public void add(WordAddBindingModel wordAddBindingModel) {
        Language language = languageRepository.findByLanguageName(wordAddBindingModel.getLanguage());
        if(language != null) {

            Word word = new Word();
            word.setTerm(wordAddBindingModel.getTerm());
            word.setTranslation(wordAddBindingModel.getTranslation());
            word.setExample(wordAddBindingModel.getExample());
            word.setInputDate(LocalDate.parse(wordAddBindingModel.getInputDate()));
            wordRepository.save(word);
        }
    }
}
