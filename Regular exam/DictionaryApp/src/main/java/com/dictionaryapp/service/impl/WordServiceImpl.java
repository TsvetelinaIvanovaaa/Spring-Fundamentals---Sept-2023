package com.dictionaryapp.service.impl;

import com.dictionaryapp.model.dto.word.WordAddBindingModel;
import com.dictionaryapp.model.dto.word.WordHomeViewModel;
import com.dictionaryapp.model.entity.Language;
import com.dictionaryapp.model.entity.User;
import com.dictionaryapp.model.entity.Word;
import com.dictionaryapp.model.enums.LanguageNameEnum;
import com.dictionaryapp.repo.LanguageRepository;
import com.dictionaryapp.repo.UserRepository;
import com.dictionaryapp.repo.WordRepository;
import com.dictionaryapp.service.WordService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WordServiceImpl implements WordService {

    private final WordRepository wordRepository;
    private final LanguageRepository languageRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public WordServiceImpl(WordRepository wordRepository, LanguageRepository languageRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.wordRepository = wordRepository;
        this.languageRepository = languageRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
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

    @Override
    public void addedBy(Long id, String username) {
        Optional<Word> optionalWord = wordRepository.findById(id);

        if (optionalWord.isPresent()) {
            Word word =optionalWord.get();

            if (username == null) {
                word.setAddedBy(null);
            } else {
                User user = userRepository.findByUsername(username);
                word.setAddedBy(user);
            }
            wordRepository.save(word);
        }
    }

    @Override
    public void removeById(Long id) {
        wordRepository.deleteById(id);
    }

    @Override
    public void removeAll() {
        wordRepository.deleteAll();
    }

    public Long allWordsCount() {
        return wordRepository.count();
    }

    @Override
    public List<WordHomeViewModel> getHomeViewData(String username) {
        User user = userRepository.findByUsername(username);
//        List<WordHomeViewModel> availableWords = wordRepository.getAllAvailableWords()
//                .stream()
//                .map(word -> modelMapper.map(word, WordHomeViewModel.class))
//                .collect(Collectors.toList());
//
//        return new WordHomeViewModel(addedWords, availableWords);
          return wordRepository.findByAddedBy(user)
                  .stream()
                  .map(word -> modelMapper.map(word, WordHomeViewModel.class))
                  .collect(Collectors.toList());
    }

    public List<WordHomeViewModel> findAllWordsByLanguage(LanguageNameEnum languageNameEnum) {
        return wordRepository.findByLanguage_Name(languageNameEnum)
                .stream()
                .map(word -> modelMapper.map(word, WordHomeViewModel.class))
                .collect(Collectors.toList());
    }
}
