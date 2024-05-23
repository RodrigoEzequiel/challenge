package com.librosapi.challenge.localapi.service;

import com.librosapi.challenge.localapi.model.Author;
import com.librosapi.challenge.localapi.model.Book;
import com.librosapi.challenge.localapi.repository.AuthorRepository;
import com.librosapi.challenge.localapi.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository repository;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository repository, AuthorRepository authorRepository) {
        this.repository = repository;
        this.authorRepository = authorRepository;
    }

    public Book guardar(Book b){
        Book exist = repository.existBook(b.getTitle());
        if(exist == null){
            List<Author> existentes =
            b.getAuthors().stream().map(
                    author -> {
                        Author a = authorRepository.existAuthor(author.getName());
                        if (a == null)
                            return author;

                        else return a;
                    }
            ).collect(Collectors.toList());
            b.setAuthors(existentes);
            return repository.save(b);
        }
        System.out.println("LIBRO YA SE ENCUENTRA REGISTRADO");
        return exist;
    }
    public List<Book> listarLibrosRegistrados(){
        return repository.findAll();
    }
    public List<Book> top5(){
        return repository.top5();
    }
}
