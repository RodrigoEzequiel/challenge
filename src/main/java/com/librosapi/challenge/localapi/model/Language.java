package com.librosapi.challenge.localapi.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name= "idiomas")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 2, unique = true)
    private String languageCode;
    private List<Book> books = new ArrayList<>();

    public Language() {
    }

    public Language(String languageCode) {
        this.languageCode = languageCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Language language = (Language) o;
        return Objects.equals(id, language.id) && Objects.equals(languageCode, language.languageCode) && Objects.equals(books, language.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, languageCode, books);
    }

    @Override
    public String toString() {
        return "Language{" +
                "id=" + id +
                ", languageCode='" + languageCode + '\'' +
                '}';
    }
}
