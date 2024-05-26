package com.librosapi.challenge.localapi.model;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "libros")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", nullable = false, unique = true )
    private String title;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "libros_autores",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id")})
    private List<Author> authors = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "libros_lenguajes",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "lenguaje_id")})
    private List<Language> languages = new ArrayList<>();

    @Column(name = "descargas")
    private Long download_count;

    public Book() {
    }

    public Book(Long id, String title, List<Author> authors, List<Language> languages, Long download_count) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.languages = languages;
        this.download_count = download_count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public Long getDownload_count() {
        return download_count;
    }

    public void setDownload_count(Long download_count) {
        this.download_count = download_count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) && Objects.equals(title, book.title) && Objects.equals(authors, book.authors) && Objects.equals(languages, book.languages) && Objects.equals(download_count, book.download_count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, authors, languages, download_count);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", authors=" + authors +
                ", languages=" + languages +
                ", download_count=" + download_count +
                '}';
    }
}
