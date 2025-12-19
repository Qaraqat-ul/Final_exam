package com.example.cinema.controller;

import com.example.Final_exam.dto.DirectorDto;
import com.example.Final_exam.service.DirectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/directors")
@RequiredArgsConstructor
public class DirectorController {

    private final DirectorService directorService;

    @GetMapping
    public List<DirectorDto> all() {
        return directorService.getAll();
    }
}
