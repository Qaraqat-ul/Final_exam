package com.example.Final_exam.mapper;

import com.example.Final_exam.dto.MovieRequest;
import com.example.Final_exam.dto.MovieResponse;
import com.example.Final_exam.entity.Movie;

import java.util.Set;
import java.util.stream.Collectors;

public class MovieMapper {

    public static Movie toEntity(MovieRequest request, Set<Genre> genres) {
        return Movie.builder()
                .title(request.getTitle())
                .releaseDate(request.getReleaseDate())
                .description(request.getDescription())
                .durationMinutes(request.getDurationMinutes())
                .genres(genres)
                .build();
    }

    public static MovieResponse toResponse(Movie movie) {
        MovieResponse response = new MovieResponse();
        response.setId(movie.getId());
        response.setTitle(movie.getTitle());
        response.setReleaseDate(movie.getReleaseDate());
        response.setDescription(movie.getDescription());
        response.setDurationMinutes(movie.getDurationMinutes());
        response.setGenres(
                movie.getGenres().stream()
                        .map(GenreMapper::toResponse)
                        .collect(Collectors.toSet())
        );
        return response;
    }
}
