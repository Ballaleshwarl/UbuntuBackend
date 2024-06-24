package com.selfWebapp.selfWebappArtifact.repository;

import com.selfWebapp.selfWebappArtifact.entity.LraUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LraUserRepository extends JpaRepository<LraUser,Long> {

    LraUser findByEmail(String email);
}
