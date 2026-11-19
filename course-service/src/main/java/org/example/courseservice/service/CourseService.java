package org.example.courseservice.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.example.courseservice.client.InventoryClient;
import org.example.courseservice.dto.InventoryDto;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    private final InventoryClient inventoryClient;

    public CourseService(InventoryClient inventoryClient) {
        this.inventoryClient = inventoryClient;
    }

    @CircuitBreaker(name = "inventoryService", fallbackMethod = "inventoryFallback")
    public InventoryDto getInventory(Long courseId) {
        return inventoryClient.getInventory(courseId);
    }

    private InventoryDto inventoryFallback(Long courseId, Throwable ex) {
        return new InventoryDto(courseId, false);
    }
}