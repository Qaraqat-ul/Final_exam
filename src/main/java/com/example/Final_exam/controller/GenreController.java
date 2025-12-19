package com.example.Final_exam.controller;

import com.example.Final_exam.dto.GenreDto;
import com.example.Final_exam.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/genres")
@RequiredArgsConstructor
public class GenreController {

    private final GenreService genreService;

    @GetMapping
    public List<GenreDto> all() {
        return genreService.getAll();
    }
}
