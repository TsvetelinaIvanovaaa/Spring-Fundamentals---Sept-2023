package com.dictionaryapp.repo;

import com.dictionaryapp.model.entity.Word;
import com.dictionaryapp.model.enums.LanguageNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface WordRepository extends JpaRepository<Word, Long> {

    List<Word> findByLanguage_Name(LanguageNameEnum languageNameEnum);
}
