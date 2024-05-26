package com.librosapi.challenge.localapi.service;


import com.librosapi.challenge.apiexterna.model.BookDTO;
import com.librosapi.challenge.localapi.model.Author;
import com.librosapi.challenge.localapi.model.Book;
import com.librosapi.challenge.localapi.model.Language;

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
                                    authorDTO -> {
                                        Author a = new Author();
                                        a.setFechaNacimiento(authorDTO.birth_year());
                                        a.setFechaFallecimiento(authorDTO.death_year());

                                        if (authorDTO.name()==null || authorDTO.name().isEmpty()){
                                            a.setName("DESCONOCIDO");
                                        } else {
                                            a.setName(authorDTO.name());
                                        }

                                        if (a.getName().contains(",")){
                                            String[] parts = a.getName().split(",");
                                            a.setLastName(parts[0]);
                                            a.setFirstName(parts[1]);
                                        } else {
                                            a.setFirstName(authorDTO.name());
                                            a.setLastName(authorDTO.name());
                                        }

                                        return  a;
                                    }
                            ).collect(Collectors.toList())
                    );
                    b.setLanguages(libroDto.languages().stream().map(Language::new).collect(Collectors.toList()));
                    return b;
                }
        ).collect(Collectors.toList());
        return convertidos;
    }
}
