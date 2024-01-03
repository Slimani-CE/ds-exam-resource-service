package com.slimani.resourceservice.controller;

import com.slimani.resourceservice.dto.ResourceRequestDTO;
import com.slimani.resourceservice.dto.ResourceResponseDTO;
import com.slimani.resourceservice.exceptions.ResourceNotFoundException;
import com.slimani.resourceservice.service.ResourceService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/resources")
public class ResourceRestController {
    private final ResourceService resourceService;

    public ResourceRestController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    // Get authenticated user
    @GetMapping("/auth")
    @ResponseBody
    public ResponseEntity<Principal> getAuthenticatedUser(Authentication auth) {
        if (auth == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(auth);
    }

    // Save a new resource
    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ResourceResponseDTO> saveResource(@RequestBody ResourceRequestDTO resourceRequestDTO) {
        return ResponseEntity.ok(resourceService.saveResource(resourceRequestDTO));
    }

    // Get All Resources
    @GetMapping
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<List<ResourceResponseDTO>> getAllResources() {
        return ResponseEntity.ok(resourceService.getAllResources());
    }

    // Get Resource By Id
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<ResourceResponseDTO> getResourceById(@PathVariable String id) {
        try {
            return ResponseEntity.ok(resourceService.getResourceById(id));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete Resource
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Void> deleteResource(@PathVariable String id) {
        try {
            resourceService.deleteResource(id);
            return ResponseEntity.ok().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Patch Resource
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ResourceResponseDTO> patchResource(@PathVariable String id, @RequestBody ResourceRequestDTO resourceRequestDTO) {
        try {
            return ResponseEntity.ok(resourceService.patchResource(id, resourceRequestDTO));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
