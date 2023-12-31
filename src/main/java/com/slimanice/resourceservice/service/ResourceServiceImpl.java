package com.slimanice.resourceservice.service;

import com.slimanice.resourceservice.dto.ResourceRequestDTO;
import com.slimanice.resourceservice.dto.ResourceResponseDTO;
import com.slimanice.resourceservice.entity.Resource;
import com.slimanice.resourceservice.mapper.ResourceMapper;
import com.slimanice.resourceservice.repository.ResourceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ResourceServiceImpl implements ResourceService {
    private final ResourceRepository resourceRepository;
    private final ResourceMapper resourceMapper;

    public ResourceServiceImpl(ResourceRepository resourceRepository, ResourceMapper resourceMapper) {
        this.resourceRepository = resourceRepository;
        this.resourceMapper = resourceMapper;
    }

    @Override
    public ResourceResponseDTO saveResource(ResourceRequestDTO resourceRequestDTO) {
        Resource savedResource = resourceRepository.save(resourceMapper.mapToResource(resourceRequestDTO));
        return resourceMapper.mapToResourceResponseDTO(savedResource);
    }

    @Override
    public List<ResourceResponseDTO> getAllResources() {
        return resourceRepository.findAll().stream().map(resourceMapper::mapToResourceResponseDTO).toList();
    }
}