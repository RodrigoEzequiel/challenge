package com.librosapi.challenge.localapi.service;

import com.librosapi.challenge.localapi.model.Author;
import com.librosapi.challenge.localapi.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorsService {
    private final AuthorRepository repository;

    public AuthorsService(AuthorRepository repository) {
        this.repository = repository;
    }

    public List<Author> autoresVivos(){
        return repository.autoresVivos();
    }

    public List<Author> autoresPorApellido(String buscado) {
        return repository.findByLastNameIgnoreCase(buscado);
    }
}
