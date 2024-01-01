package com.slimani.resourceservice.controller;

import com.slimani.resourceservice.dto.ResourceResponseDTO;
import com.slimani.resourceservice.service.ResourceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/resources")
public class ResourceRestController {
    private final ResourceService resourceService;

    public ResourceRestController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    // Get All Resources
    @GetMapping
    public ResponseEntity<List<ResourceResponseDTO>> getAllResources() {
        return ResponseEntity.ok(resourceService.getAllResources());
    }
}
