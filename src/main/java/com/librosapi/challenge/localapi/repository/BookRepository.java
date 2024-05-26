package com.librosapi.challenge.localapi.repository;

import com.librosapi.challenge.localapi.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {


    public Book findByTitle(String title);

    @Query(value = "SELECT b FROM Book b ORDER BY b.download_count DESC LIMIT 5")
    public List<Book> top5();
}
