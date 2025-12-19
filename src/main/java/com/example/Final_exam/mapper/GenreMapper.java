package com.example.Final_exam.mapper;

import com.example.Final_exam.dto.GenreResponse;

public class GenreMapper {

    public static GenreResponse toResponse(Genre genre) {
        GenreResponse response = new GenreResponse();
        response.setId(genre.getId());
        response.setName(genre.getName());
        return response;
    }
}
