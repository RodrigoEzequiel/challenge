package com.librosapi.challenge.apiexterna.model;


import java.util.List;

public record ApiResponseDTO(Long count,
                             String next,
                             String previous,
                             List<BookDTO> results) {
}
