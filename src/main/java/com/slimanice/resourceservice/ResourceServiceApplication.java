package com.slimanice.resourceservice;

import com.slimanice.resourceservice.dto.ResourceRequestDTO;
import com.slimanice.resourceservice.enums.ResourceType;
import com.slimanice.resourceservice.service.ResourceServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Random;

@SpringBootApplication
public class ResourceServiceApplication {
	private final ResourceServiceImpl resourceService;

	public ResourceServiceApplication(ResourceServiceImpl resourceService) {
		this.resourceService = resourceService;
	}

	public static void main(String[] args) {
		SpringApplication.run(ResourceServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start() {
		return args -> {
			// Create mockup data for testing
			List.of("HP Laptop", "Dell Laptop", "Asus Laptop", "Printer", "Scanner", "Projector", "Server").forEach(name -> {
				resourceService.saveResource(ResourceRequestDTO.builder()
								.type(new Random().nextDouble() > 0.5 ? ResourceType.INFO_MATERIAL : ResourceType.VIDEO_AUDIO_MATERIAL)
								.name(name)
								.build());
			});
		};
	}
}
