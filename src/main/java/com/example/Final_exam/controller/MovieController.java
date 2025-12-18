package com.example.Final_exam.controller;

import com.example.Final_exam.dto.MovieRequest;
import com.example.Final_exam.dto.MovieResponse;
import com.example.Final_exam.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    public List<MovieResponse> getAll() {
        return movieService.getAll();
    }

    @GetMapping("/{id}")
    public MovieResponse getById(@PathVariable Long id) {
        return movieService.getById(id);
    }

    @PostMapping
    public MovieResponse create(@RequestBody MovieRequest request) {
        return movieService.create(request);
    }

    @PutMapping("/{id}")
    public MovieResponse update(@PathVariable Long id, @RequestBody MovieRequest request) {
        return movieService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        movieService.delete(id);
    }
}
