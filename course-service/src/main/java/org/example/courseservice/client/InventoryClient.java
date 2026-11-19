package org.example.courseservice.client;

import org.example.courseservice.dto.InventoryDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "inventoryClient", url = "${inventory-service.url}")
public interface InventoryClient {

    @GetMapping("/inventory/{courseId}")
    InventoryDto getInventory(@PathVariable("courseId") Long courseId);
}