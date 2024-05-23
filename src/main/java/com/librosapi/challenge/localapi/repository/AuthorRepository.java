package com.librosapi.challenge.localapi.repository;

import com.librosapi.challenge.localapi.model.Author;
import com.librosapi.challenge.localapi.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query(value = "SELECT a FROM Author a WHERE a.fechaFallecimiento IS NULL")
    public List<Author> autoresVivos();

    @Query(value = "SELECT a FROM Author a WHERE a.name =:nombreCompleto ")
    public Author existAuthor(String nombreCompleto);
}
