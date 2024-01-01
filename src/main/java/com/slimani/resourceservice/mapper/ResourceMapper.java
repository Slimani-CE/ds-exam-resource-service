package com.slimani.resourceservice.mapper;

import com.slimani.resourceservice.dto.ResourceRequestDTO;
import com.slimani.resourceservice.dto.ResourceResponseDTO;
import com.slimani.resourceservice.entity.Resource;
import org.springframework.stereotype.Component;

@Component
public class ResourceMapper {
    public ResourceResponseDTO mapToResourceResponseDTO(Resource resource) {
        return ResourceResponseDTO.builder()
                .id(resource.getId())
                .name(resource.getName())
                .type(resource.getType())
                .build();
    }

    public Resource mapToResource(ResourceRequestDTO resourceRequestDTO) {
        return Resource.builder()
                .name(resourceRequestDTO.getName())
                .type(resourceRequestDTO.getType())
                .build();
    }
}
