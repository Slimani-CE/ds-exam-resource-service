package com.slimanice.resourceservice.dto;

import com.slimanice.resourceservice.enums.ResourceType;
import lombok.*;

@Getter @Setter @Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResourceRequestDTO {
    private String name;
    private ResourceType type;
}
