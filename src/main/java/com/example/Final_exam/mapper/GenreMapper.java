package com.example.Final_exam.mapper;

import com.example.Final_exam.dto.GenreDto;
import com.example.Final_exam.entity.Genre;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GenreMapper {
    GenreDto toDto(Genre genre);
}
