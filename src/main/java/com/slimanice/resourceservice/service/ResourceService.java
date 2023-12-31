package com.slimanice.resourceservice.service;

import com.slimanice.resourceservice.dto.ResourceRequestDTO;
import com.slimanice.resourceservice.dto.ResourceResponseDTO;

import java.util.List;

public interface ResourceService {

    // Save Resource
    public ResourceResponseDTO saveResource(ResourceRequestDTO resourceRequestDTO);

    // Get All Resources
    public List<ResourceResponseDTO> getAllResources() ;
}
