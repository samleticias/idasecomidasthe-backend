package com.ifpi.idasecomidasthe.dto.store;

public record StoreDTO(
        String name,
        String description,
        String openingHours,
        Double latitude,
        Double longitude,
        Long categoryId
) {}

