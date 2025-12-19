package com.example.Final_exam.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

public record MovieDto(
        Long id,
        @NotBlank String title,
        @NotNull Long directorId,
        Set<Long> genreIds
) {}
