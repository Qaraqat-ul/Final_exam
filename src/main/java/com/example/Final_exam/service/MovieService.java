package com.example.Final_exam.service;

import com.example.Final_exam.dto.MovieDto;

import java.util.List;

public interface MovieService {
    MovieDto create(MovieDto dto);
    MovieDto getById(Long id);
    List<MovieDto> getAll();
    MovieDto update(Long id, MovieDto dto);
    void delete(Long id);
}
