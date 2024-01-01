package com.slimani.resourceservice.dto;

import com.slimani.resourceservice.enums.ResourceType;
import lombok.*;

@Getter @Setter @Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResourceRequestDTO {
    private String name;
    private ResourceType type;
}
