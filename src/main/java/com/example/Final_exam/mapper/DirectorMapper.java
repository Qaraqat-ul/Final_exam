package com.example.Final_exam.mapper;

import com.example.Final_exam.dto.DirectorDto;
import com.example.Final_exam.entity.Director;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DirectorMapper {
    DirectorDto toDto(Director director);
}
