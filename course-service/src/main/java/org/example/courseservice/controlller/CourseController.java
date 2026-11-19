package org.example.courseservice.controlller;

import org.example.courseservice.dto.InventoryDto;
import org.example.courseservice.service.CourseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/{courseId}/inventory")
    public InventoryDto getInventory(@PathVariable Long courseId) {
        return courseService.getInventory(courseId);
    }
}