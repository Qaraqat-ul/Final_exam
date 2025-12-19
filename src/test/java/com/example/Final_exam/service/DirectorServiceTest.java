package com.example.Final_exam.service;

import com.example.Final_exam.dto.DirectorDto;
import com.example.Final_exam.entity.Director;
import com.example.Final_exam.mapper.DirectorMapper;
import com.example.Final_exam.repository.DirectorRepository;
import com.example.Final_exam.service.impl.DirectorServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DirectorServiceTest {

    @Mock
    private DirectorRepository directorRepository;

    @Mock
    private DirectorMapper directorMapper;

    @InjectMocks
    private DirectorServiceImpl directorService;

    @Test
    void getAllTest() {
        Director director = new Director();
        director.setId(1L);
        director.setFullName("Nolan");

        DirectorDto dto = new DirectorDto(1L, "Nolan");

        when(directorRepository.findAll()).thenReturn(List.of(director));
        when(directorMapper.toDto(director)).thenReturn(dto);

        List<DirectorDto> result = directorService.getAll();

        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals(1L, result.get(0).id());
        Assertions.assertEquals("Nolan", result.get(0).fullName());
    }
}
