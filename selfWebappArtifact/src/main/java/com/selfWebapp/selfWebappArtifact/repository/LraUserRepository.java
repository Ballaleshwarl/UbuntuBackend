package com.selfWebapp.selfWebappArtifact.repository;

import com.selfWebapp.selfWebappArtifact.entity.lraUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LraUserRepository extends JpaRepository<lraUser,Long> {

    lraUser findByName(String name);
}
