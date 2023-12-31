package com.slimanice.resourceservice.repository;

import com.slimanice.resourceservice.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resource, String> {

}
