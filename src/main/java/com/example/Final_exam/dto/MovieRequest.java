package com.example.Final_exam.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
public class MovieRequest {
    private String title;
    private LocalDate releaseDate;
    private String description;
    private Integer durationMinutes;
    private Set<String> genres;
}
