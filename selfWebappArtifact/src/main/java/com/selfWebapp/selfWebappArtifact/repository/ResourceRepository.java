package com.selfWebapp.selfWebappArtifact.repository;

import com.selfWebapp.selfWebappArtifact.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resource,Long> {

}
