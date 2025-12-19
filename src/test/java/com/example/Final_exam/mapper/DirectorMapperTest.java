package com.example.Final_exam.mapper;

import com.example.Final_exam.dto.DirectorDto;
import com.example.Final_exam.entity.Director;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class DirectorMapperTest {

    private final DirectorMapper directorMapper =
            Mappers.getMapper(DirectorMapper.class);

    @Test
    void toDtoTest() {
        Director director = new Director();
        director.setId(1L);
        director.setFullName("Christopher Nolan");

        DirectorDto dto = directorMapper.toDto(director);

        Assertions.assertNotNull(dto);
        Assertions.assertEquals(1L, dto.id());
        Assertions.assertEquals("Christopher Nolan", dto.fullName());
    }

}
