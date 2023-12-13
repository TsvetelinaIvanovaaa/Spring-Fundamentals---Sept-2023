package com.dictionaryapp.service;

import com.dictionaryapp.model.dto.word.WordAddBindingModel;
import com.dictionaryapp.model.dto.word.WordViewDto;
import com.dictionaryapp.model.entity.Word;
import com.dictionaryapp.model.enums.LanguageNameEnum;
import com.dictionaryapp.model.service.WordServiceModel;
import com.dictionaryapp.repo.WordRepository;
import com.dictionaryapp.util.LoggedUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WordService {

    private final WordRepository wordRepository;

    private final ModelMapper modelMapper;

    private final LoggedUser loggedUser;

    private final UserService userService;

    private final LanguageService languageService;

    public WordService(WordRepository wordRepository, ModelMapper modelMapper, LoggedUser loggedUser, UserService userService, LanguageService languageService) {
        this.wordRepository = wordRepository;
        this.modelMapper = modelMapper;
        this.loggedUser = loggedUser;
        this.userService = userService;
        this.languageService = languageService;
    }

    public void addWord(WordServiceModel wordServiceModel) {
        Word word = modelMapper.map(wordServiceModel, Word.class);

        word.setAddedBy(userService.findById(loggedUser.getId()));
        word.setLanguage(languageService.findByLanguageNameEnum(wordServiceModel.getLanguage()));

        wordRepository.save(word);
    }

    public List<WordViewDto> findAllWordsByLanguage(LanguageNameEnum languageNameEnum) {
        return wordRepository.findByLanguage_Name(languageNameEnum)
                .stream()
                .map(word -> modelMapper.map(word, WordViewDto.class))
                .collect(Collectors.toList());
    }


    public void removeById(Long id) {
        wordRepository.deleteById(id);
    }

    public void removeAll() {
        wordRepository.deleteAll();
    }

    public Long allWordsCount() {
        return wordRepository.count();
    }
}