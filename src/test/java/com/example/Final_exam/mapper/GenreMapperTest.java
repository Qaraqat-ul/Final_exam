package com.example.Final_exam.mapper;

import com.example.Final_exam.dto.GenreDto;
import com.example.Final_exam.entity.Genre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class GenreMapperTest {

    private final GenreMapper genreMapper =
            Mappers.getMapper(GenreMapper.class);

    @Test
    void toDtoTest() {
        Genre genre = new Genre();
        genre.setId(2L);
        genre.setName("Sci-Fi");

        GenreDto dto = genreMapper.toDto(genre);

        Assertions.assertNotNull(dto);
        Assertions.assertEquals(2L, dto.id());
        Assertions.assertEquals("Sci-Fi", dto.name());
    }
}
