package com.slimani.resourceservice.service;

import com.slimani.resourceservice.dto.ResourceRequestDTO;
import com.slimani.resourceservice.dto.ResourceResponseDTO;

import java.util.List;

public interface ResourceService {

    // Save Resource
    public ResourceResponseDTO saveResource(ResourceRequestDTO resourceRequestDTO);

    // Get All Resources
    public List<ResourceResponseDTO> getAllResources() ;
}
