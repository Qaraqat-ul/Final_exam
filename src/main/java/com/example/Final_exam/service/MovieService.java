package com.example.Final_exam.service;

import com.example.Final_exam.dto.MovieRequest;
import com.example.Final_exam.dto.MovieResponse;

import java.util.List;

public interface MovieService {
    List<MovieResponse> getAll();
    MovieResponse getById(Long id);
    MovieResponse create(MovieRequest request);
    MovieResponse update(Long id, MovieRequest request);
    void delete(Long id);
}
