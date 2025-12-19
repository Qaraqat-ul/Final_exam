package com.example.Final_exam.service;

import com.example.Final_exam.dto.MovieDto;
import com.example.Final_exam.entity.Director;
import com.example.Final_exam.entity.Movie;
import com.example.Final_exam.mapper.MovieMapper;
import com.example.Final_exam.repository.DirectorRepository;
import com.example.Final_exam.repository.GenreRepository;
import com.example.Final_exam.repository.MovieRepository;
import com.example.Final_exam.service.impl.MovieServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MovieServiceTest {

    @Mock
    private MovieRepository movieRepository;

    @Mock
    private DirectorRepository directorRepository;

    @Mock
    private GenreRepository genreRepository;

    @Mock
    private MovieMapper movieMapper;

    @InjectMocks
    private MovieServiceImpl movieService;

    @Test
    void createMovieTest() {

        Director director = new Director();
        director.setId(1L);

        MovieDto inputDto = new MovieDto(null, "Dune", 1L, Set.of());

        when(directorRepository.findById(1L)).thenReturn(Optional.of(director));
        when(genreRepository.findAllById(Set.of())).thenReturn(List.of());


        when(movieRepository.save(any(Movie.class))).thenAnswer(inv -> inv.getArgument(0));

        MovieDto expectedDto = new MovieDto(10L, "Dune", 1L, Set.of());
        when(movieMapper.toDto(any(Movie.class))).thenReturn(expectedDto);


        MovieDto result = movieService.create(inputDto);


        Assertions.assertNotNull(result);
        Assertions.assertEquals("Dune", result.title());
        Assertions.assertEquals(1L, result.directorId());
        Assertions.assertEquals(10L, result.id());


        ArgumentCaptor<Movie> captor = ArgumentCaptor.forClass(Movie.class);
        verify(movieRepository).save(captor.capture());

        Movie saved = captor.getValue();
        Assertions.assertEquals("Dune", saved.getTitle());
        Assertions.assertNotNull(saved.getDirector());
        Assertions.assertEquals(1L, saved.getDirector().getId());
        Assertions.assertNotNull(saved.getGenres());
        Assertions.assertEquals(0, saved.getGenres().size());
    }
}
