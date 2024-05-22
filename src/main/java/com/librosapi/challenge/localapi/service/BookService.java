package com.librosapi.challenge.localapi.service;

import com.librosapi.challenge.localapi.model.Book;
import com.librosapi.challenge.localapi.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }
    public Book guardar(Book b){
        Book exist = repository.existBook(b.getTitle());
        if(exist == null){
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
