package com.librosapi.challenge.localapi.service;

import com.librosapi.challenge.localapi.model.Author;
import com.librosapi.challenge.localapi.model.Book;
import com.librosapi.challenge.localapi.model.Language;
import com.librosapi.challenge.localapi.repository.AuthorRepository;
import com.librosapi.challenge.localapi.repository.BookRepository;
import com.librosapi.challenge.localapi.repository.LanguageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final LanguageRepository languageRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository, LanguageRepository languageRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.languageRepository = languageRepository;
    }

    public Book guardar(Book b){
        Book exist = bookRepository.findByTitle(b.getTitle());
        if(exist == null){
            List<Author> authors = b.getAuthors().stream().map(
                    author -> {
                        Author a = authorRepository.findByName(author.getName());
                        if (a == null) return authorRepository.save(author);
                        else return a;
                    }
            ).collect(Collectors.toList());
            b.setAuthors(authors);
            List<Language> idioms = b.getLanguages().stream().map(
                    language -> {
                        Language l = languageRepository.findByLanguageCode(language.getLanguageCode());
                        if (l == null) return languageRepository.save(language);
                        else return l;
                    }
            ).collect(Collectors.toList());
            b.setLanguages(idioms);
            System.err.println("GUARDANDO LIBRO NUEVO: " + b.getTitle());
            return bookRepository.save(b);
        }
        System.err.println("YA SE ENCUENTRA REGISTRADO: " + b.getTitle());
        return exist;
    }
    public List<Book> listarLibrosRegistrados(){
        return bookRepository.findAll();
    }
    public List<Book> top5(){
        return bookRepository.top5();
    }
}
