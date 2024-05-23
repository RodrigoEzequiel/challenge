package com.librosapi.challenge.localapi.service;

import com.librosapi.challenge.apiexterna.model.AuthorDTO;
import com.librosapi.challenge.apiexterna.model.BookDTO;
import com.librosapi.challenge.localapi.model.Author;
import com.librosapi.challenge.localapi.model.Book;

import java.util.List;
import java.util.stream.Collectors;

public class ApiResponseManager {
    public List<Book> convertirDtoAEntidad(List<BookDTO> results){
        List<Book> convertidos = results.stream().map(
                libroDto->{
                    Book b = new Book();
                    b.setTitle(libroDto.title());
                    b.setDownload_count(libroDto.download_count());

                    b.setAuthors(
                            libroDto.authors().stream().map(
                                    AuthorDTO->{
                                        Author a = new Author();
                                        a.setFechaNacimiento(AuthorDTO.birth_year());
                                        a.setFechaFallecimiento(AuthorDTO.death_year());
                                        a.setName(AuthorDTO.name());
                                        String[] parts = AuthorDTO.name().split(",");
                                        a.setLastName(parts[0]);
                                        a.setFirstName(parts[1]);
                                        return  a;
                                    }
                            ).collect(Collectors.toList())
                    );
                    return b;
                }
        ).collect(Collectors.toList());
        return convertidos;
    }
}
