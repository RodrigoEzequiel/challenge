package com.librosapi.challenge.apiexterna.model;

import java.util.List;

public record BookDTO(Long id,
        String title,
        List<AuthorDTO> authors,
        List<String> languages,
        Long download_count) {

}
