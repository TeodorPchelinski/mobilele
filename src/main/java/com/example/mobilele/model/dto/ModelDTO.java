package com.example.mobilele.model.dto;

public record ModelDTO(long id, String name) {
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
