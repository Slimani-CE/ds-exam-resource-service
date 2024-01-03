package com.slimani.resourceservice.service;

import com.slimani.resourceservice.dto.ResourceRequestDTO;
import com.slimani.resourceservice.dto.ResourceResponseDTO;
import com.slimani.resourceservice.exceptions.ResourceNotFoundException;

import java.util.List;

public interface ResourceService {

    // Save Resource
    ResourceResponseDTO saveResource(ResourceRequestDTO resourceRequestDTO);

    // Get All Resources
    List<ResourceResponseDTO> getAllResources() ;

    // Get Resource By Id
    ResourceResponseDTO getResourceById(String id) throws ResourceNotFoundException;

    // Delete Resource
    void deleteResource(String id) throws ResourceNotFoundException;

    // Patch Resource
    ResourceResponseDTO patchResource(String id, ResourceRequestDTO resourceRequestDTO) throws ResourceNotFoundException;
}
