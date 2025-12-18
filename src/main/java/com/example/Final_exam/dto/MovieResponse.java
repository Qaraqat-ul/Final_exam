package com.example.Final_exam.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
public class MovieResponse {
    private Long id;
    private String title;
    private LocalDate releaseDate;
    private String description;
    private Integer durationMinutes;
    private Set<GenreResponse> genres;
}
