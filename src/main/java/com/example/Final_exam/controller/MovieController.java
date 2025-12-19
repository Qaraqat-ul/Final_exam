package com.example.cinema.controller;

import com.example.Final_exam.dto.MovieDto;
import com.example.Final_exam.service.GenreService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
public class MovieController {

    private final GenreService movieService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MovieDto create(@Valid @RequestBody MovieDto dto) {
        return movieService.create(dto);
    }

    @GetMapping("/{id}")
    public MovieDto get(@PathVariable Long id) {
        return movieService.getById(id);
    }

    @GetMapping
    public List<MovieDto> all() {
        return movieService.getAll();
    }

    @PutMapping("/{id}")
    public MovieDto update(@PathVariable Long id, @RequestBody MovieDto dto) {
        return movieService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        movieService.delete(id);
    }
}
