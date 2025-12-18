package com.example.Final_exam.controller;

import com.example.Final_exam.dto.CinemaRequest;
import com.example.Final_exam.dto.CinemaResponse;
import com.example.Final_exam.service.CinemaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cinemas")
@RequiredArgsConstructor
public class CinemaController {

    private final CinemaService cinemaService;

    @GetMapping
    public List<CinemaResponse> getAll() {
        return cinemaService.getAll();
    }

    @GetMapping("/{id}")
    public CinemaResponse getById(@PathVariable Long id) {
        return cinemaService.getById(id);
    }

    @PostMapping
    public CinemaResponse create(@RequestBody CinemaRequest request) {
        return cinemaService.create(request);
    }

    @PutMapping("/{id}")
    public CinemaResponse update(@PathVariable Long id, @RequestBody CinemaRequest request) {
        return cinemaService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        cinemaService.delete(id);
    }
}
