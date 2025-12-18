package com.example.Final_exam.mapper;

import com.example.Final_exam.dto.GenreResponse;
import com.example.Final_exam.entity.Genre;

public class GenreMapper {

    public static GenreResponse toResponse(Genre genre) {
        GenreResponse response = new GenreResponse();
        response.setId(genre.getId());
        response.setName(genre.getName());
        return response;
    }
}
