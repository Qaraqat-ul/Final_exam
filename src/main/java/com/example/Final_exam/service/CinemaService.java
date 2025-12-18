package com.example.Final_exam.service;

import com.example.Final_exam.dto.CinemaRequest;
import com.example.Final_exam.dto.CinemaResponse;

import java.util.List;

public interface CinemaService {
    List<CinemaResponse> getAll();
    CinemaResponse getById(Long id);
    CinemaResponse create(CinemaRequest request);
    CinemaResponse update(Long id, CinemaRequest request);
    void delete(Long id);
}
