package com.example.Final_exam.service.impl;

import com.example.Final_exam.dto.CinemaRequest;
import com.example.Final_exam.dto.CinemaResponse;
import com.example.Final_exam.entity.Director;
import com.example.Final_exam.mapper.CinemaMapper;
import com.example.Final_exam.repository.DirectorRepository;
import com.example.Final_exam.service.CinemaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CinemaServiceImpl implements CinemaService {

    private final DirectorRepository cinemaRepository;

    @Override
    public List<CinemaResponse> getAll() {
        return cinemaRepository.findAll().stream()
                .map(CinemaMapper::toResponse)
                .toList();
    }

    @Override
    public CinemaResponse getById(Long id) {
        Director cinema = cinemaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cinema not found: " + id));
        return CinemaMapper.toResponse(cinema);
    }

    @Override
    public CinemaResponse create(CinemaRequest request) {
        Director cinema = CinemaMapper.toEntity(request);
        return CinemaMapper.toResponse(cinemaRepository.save(cinema));
    }

    @Override
    public CinemaResponse update(Long id, CinemaRequest request) {
        Director cinema = cinemaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cinema not found: " + id));
        CinemaMapper.update(cinema, request);
        return CinemaMapper.toResponse(cinemaRepository.save(cinema));
    }

    @Override
    public void delete(Long id) {
        cinemaRepository.deleteById(id);
    }
}
