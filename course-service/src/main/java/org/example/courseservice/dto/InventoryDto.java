package org.example.courseservice.dto;

public record InventoryDto(
        Long courseId,
        boolean available
) {
}