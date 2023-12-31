package com.slimanice.resourceservice.dto;

import com.slimanice.resourceservice.enums.ResourceType;
import lombok.*;

@Getter  @Setter @Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResourceResponseDTO {
    private String id;
    private String name;
    private ResourceType type;
}
