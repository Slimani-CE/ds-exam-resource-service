package com.slimani.resourceservice.repository;

import com.slimani.resourceservice.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resource, String> {

}
