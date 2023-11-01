package com.dictionaryapp.repo;

import com.dictionaryapp.model.entity.User;
import com.dictionaryapp.model.entity.Word;
import com.dictionaryapp.model.enums.LanguageNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordRepository extends JpaRepository<Word, Long> {

    List<Word> findByAddedBy(User user);

    List<Word> findByLanguage_Name(LanguageNameEnum languageNameEnum);

//    @Query(nativeQuery = true, value = "SELECT * FROM words WHERE addedBy IS NULL")
//    List<Word> getAllAvailableWords();
}
