package com.example.Final_exam.service.impl;

import com.example.Final_exam.dto.MovieDto;
import com.example.Final_exam.entity.Director;
import com.example.Final_exam.entity.Genre;
import com.example.Final_exam.entity.Movie;
import com.example.Final_exam.mapper.MovieMapper;
import com.example.Final_exam.repository.DirectorRepository;
import com.example.Final_exam.repository.GenreRepository;
import com.example.Final_exam.repository.MovieRepository;
import com.example.Final_exam.service.MovieService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final DirectorRepository directorRepository;
    private final GenreRepository genreRepository;
    private final MovieMapper movieMapper;

    @Override
    public MovieDto create(MovieDto dto) {
        Director director = directorRepository.findById(dto.directorId())
                .orElseThrow(() -> new EntityNotFoundException("Director not found"));

        Set<Genre> genres = (dto.genreIds() == null) ? Set.of()
                : new HashSet<>(genreRepository.findAllById(dto.genreIds()));

        Movie movie = new Movie();
        movie.setTitle(dto.title());
        movie.setDirector(director);
        movie.setGenres(genres);

        return movieMapper.toDto(movieRepository.save(movie));
    }

    @Override
    public MovieDto getById(Long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Movie not found"));
        return movieMapper.toDto(movie);
    }

    @Override
    public List<MovieDto> getAll() {
        return movieRepository.findAll().stream().map(movieMapper::toDto).toList();
    }

    @Override
    public MovieDto update(Long id, MovieDto dto) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Movie not found"));

        if (dto.title() != null) movie.setTitle(dto.title());

        if (dto.directorId() != null) {
            Director director = directorRepository.findById(dto.directorId())
                    .orElseThrow(() -> new EntityNotFoundException("Director not found"));
            movie.setDirector(director);
        }

        if (dto.genreIds() != null) {
            Set<Genre> genres = new HashSet<>(genreRepository.findAllById(dto.genreIds()));
            movie.setGenres(genres);
        }

        return movieMapper.toDto(movieRepository.save(movie));
    }

    @Override
    public void delete(Long id) {
        if (!movieRepository.existsById(id)) throw new EntityNotFoundException("Movie not found");
        movieRepository.deleteById(id);
    }
}
