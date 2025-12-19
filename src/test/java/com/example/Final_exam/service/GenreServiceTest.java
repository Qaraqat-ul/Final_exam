package com.example.Final_exam.service;

import com.example.Final_exam.dto.GenreDto;
import com.example.Final_exam.entity.Genre;
import com.example.Final_exam.mapper.GenreMapper;
import com.example.Final_exam.repository.GenreRepository;
import com.example.Final_exam.service.impl.GenreServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GenreServiceTest {

    @Mock
    private GenreRepository genreRepository;

    @Mock
    private GenreMapper genreMapper;

    @InjectMocks
    private GenreServiceImpl genreService;

    @Test
    void getAllTest() {
        Genre genre = new Genre();
        genre.setId(1L);
        genre.setName("Drama");

        GenreDto dto = new GenreDto(1L, "Drama");

        when(genreRepository.findAll()).thenReturn(List.of(genre));
        when(genreMapper.toDto(genre)).thenReturn(dto);

        List<GenreDto> result = genreService.getAll();

        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals(1L, result.get(0).id());
        Assertions.assertEquals("Drama", result.get(0).name());
    }
}
