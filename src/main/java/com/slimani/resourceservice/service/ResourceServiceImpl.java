package com.slimani.resourceservice.service;

import com.slimani.resourceservice.dto.ResourceRequestDTO;
import com.slimani.resourceservice.dto.ResourceResponseDTO;
import com.slimani.resourceservice.entity.Resource;
import com.slimani.resourceservice.exceptions.ResourceNotFoundException;
import com.slimani.resourceservice.mapper.ResourceMapper;
import com.slimani.resourceservice.repository.ResourceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public ResourceResponseDTO getResourceById(String id) throws ResourceNotFoundException {
        Resource resource = resourceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found with id: " + id));
        return resourceMapper.mapToResourceResponseDTO(resource);
    }

    @Override
    public void deleteResource(String id) throws ResourceNotFoundException {
        Resource resource = resourceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found with id: " + id));
        resourceRepository.delete(resource);
    }

    @Override
    public ResourceResponseDTO patchResource(String id, ResourceRequestDTO resourceRequestDTO) throws ResourceNotFoundException {
        Resource resource = resourceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found with id: " + id));
        if (resourceRequestDTO.getName() != null) resource.setName(resourceRequestDTO.getName());
        if (resourceRequestDTO.getType() != null) resource.setType(resourceRequestDTO.getType());
        Resource savedResource = resourceRepository.save(resource);
        return resourceMapper.mapToResourceResponseDTO(savedResource);
    }
}