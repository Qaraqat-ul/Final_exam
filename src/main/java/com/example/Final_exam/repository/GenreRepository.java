package com.example.Final_exam.repository;
import com.example.Final_exam.entity.Genre;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {}