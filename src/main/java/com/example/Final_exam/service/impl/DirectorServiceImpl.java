package com.example.Final_exam.service.impl;

import com.example.Final_exam.dto.DirectorDto;
import com.example.Final_exam.mapper.DirectorMapper;
import com.example.Final_exam.repository.DirectorRepository;
import com.example.Final_exam.service.DirectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DirectorServiceImpl implements DirectorService {

    private final DirectorRepository directorRepository;
    private final DirectorMapper directorMapper;

    @Override
    public List<DirectorDto> getAll() {
        return directorRepository.findAll().stream().map(directorMapper::toDto).toList();
    }
}
