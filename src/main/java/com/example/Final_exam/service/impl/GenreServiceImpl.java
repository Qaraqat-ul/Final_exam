package com.example.Final_exam.service.impl;

import com.example.Final_exam.dto.GenreDto;
import com.example.Final_exam.mapper.GenreMapper;
import com.example.Final_exam.repository.GenreRepository;
import com.example.Final_exam.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;
    private final GenreMapper genreMapper;

    @Override
    public List<GenreDto> getAll() {
        return genreRepository.findAll().stream().map(genreMapper::toDto).toList();
    }
}
