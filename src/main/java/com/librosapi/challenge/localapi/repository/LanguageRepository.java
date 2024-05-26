package com.librosapi.challenge.localapi.repository;

import com.librosapi.challenge.localapi.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {
    Language findByLanguageCode(String code);
}
