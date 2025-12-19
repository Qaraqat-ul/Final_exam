package com.example.Final_exam.mapper;

import com.example.Final_exam.dto.CinemaRequest;
import com.example.Final_exam.dto.CinemaResponse;
import com.example.Final_exam.entity.Director;

public class CinemaMapper {

    public static Director toEntity(CinemaRequest request) {
        if (request == null) return null;
        return Director.builder()
                .name(request.getName())
                .address(request.getAddress())
                .city(request.getCity())
                .build();
    }

    public static void update(Director cinema, CinemaRequest request) {
        cinema.setName(request.getName());
        cinema.setAddress(request.getAddress());
        cinema.setCity(request.getCity());
    }

    public static CinemaResponse toResponse(Director cinema) {
        CinemaResponse response = new CinemaResponse();
        response.setId(cinema.getId());
        response.setName(cinema.getName());
        response.setAddress(cinema.getAddress());
        response.setCity(cinema.getCity());
        return response;
    }
}
