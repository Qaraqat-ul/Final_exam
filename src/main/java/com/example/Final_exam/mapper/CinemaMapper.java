package com.example.Final_exam.mapper;

import com.example.Final_exam.dto.CinemaRequest;
import com.example.Final_exam.dto.CinemaResponse;
import com.example.Final_exam.entity.Cinema;

public class CinemaMapper {

    public static Cinema toEntity(CinemaRequest request) {
        if (request == null) return null;
        return Cinema.builder()
                .name(request.getName())
                .address(request.getAddress())
                .city(request.getCity())
                .build();
    }

    public static void update(Cinema cinema, CinemaRequest request) {
        cinema.setName(request.getName());
        cinema.setAddress(request.getAddress());
        cinema.setCity(request.getCity());
    }

    public static CinemaResponse toResponse(Cinema cinema) {
        CinemaResponse response = new CinemaResponse();
        response.setId(cinema.getId());
        response.setName(cinema.getName());
        response.setAddress(cinema.getAddress());
        response.setCity(cinema.getCity());
        return response;
    }
}
