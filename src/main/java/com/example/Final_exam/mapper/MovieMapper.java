package com.example.Final_exam.mapper;

import com.example.Final_exam.dto.MovieDto;
import com.example.Final_exam.entity.Genre;
import com.example.Final_exam.entity.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring", imports = {Collectors.class, Genre.class})
public interface MovieMapper {

    @Mapping(target = "directorId", source = "director.id")
    @Mapping(target = "genreIds",
            expression = "java(movie.getGenres().stream().map(Genre::getId).collect(Collectors.toSet()))")
    MovieDto toDto(Movie movie);
}
