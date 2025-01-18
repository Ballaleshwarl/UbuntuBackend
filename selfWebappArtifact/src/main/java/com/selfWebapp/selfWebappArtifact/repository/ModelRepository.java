package com.selfWebapp.selfWebappArtifact.repository;

import com.selfWebapp.selfWebappArtifact.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model,Long> {
}
