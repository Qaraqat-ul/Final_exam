package com.example.Final_exam.mapper;

import com.example.Final_exam.dto.MovieDto;
import com.example.Final_exam.entity.Director;
import com.example.Final_exam.entity.Genre;
import com.example.Final_exam.entity.Movie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.Set;

class MovieMapperTest {

    private final MovieMapper movieMapper =
            Mappers.getMapper(MovieMapper.class);

    @Test
    void toDtoTest() {
        Director director = new Director();
        director.setId(1L);

        Genre genre = new Genre();
        genre.setId(10L);

        Movie movie = new Movie();
        movie.setId(100L);
        movie.setTitle("Interstellar");
        movie.setDirector(director);
        movie.setGenres(Set.of(genre));

        MovieDto dto = movieMapper.toDto(movie);

        Assertions.assertNotNull(dto);
        Assertions.assertEquals(100L, dto.id());
        Assertions.assertEquals("Interstellar", dto.title());
        Assertions.assertEquals(1L, dto.directorId());

        Assertions.assertNotNull(dto.genreIds());
        Assertions.assertTrue(dto.genreIds().contains(10L));
    }
}
