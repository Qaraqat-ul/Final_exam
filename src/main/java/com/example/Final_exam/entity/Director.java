package com.example.Final_exam.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "directors")
@Getter @Setter
@NoArgsConstructor
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false)
    private String fullName;
}