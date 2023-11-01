package com.dictionaryapp.service;

import com.dictionaryapp.model.dto.word.WordAddBindingModel;
import com.dictionaryapp.model.dto.word.WordHomeViewModel;
import com.dictionaryapp.model.enums.LanguageNameEnum;

import java.util.List;

public interface WordService {

    void add(WordAddBindingModel wordAddBindingModel);
    void addedBy(Long id, String username);
    void removeById(Long id);
    void removeAll();
     Long allWordsCount();

    List<WordHomeViewModel> getHomeViewData(String username);

    List<WordHomeViewModel> findAllWordsByLanguage(LanguageNameEnum languageNameEnum);
}
