package com.slimanice.resourceservice.entity;

import com.slimanice.resourceservice.enums.ResourceType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class Resource {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private ResourceType type;
}
