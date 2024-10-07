package com.selfWebapp.selfWebappArtifact.repository;

import com.selfWebapp.selfWebappArtifact.entity.GlobalUsers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GlobalUsersRepository  extends JpaRepository<GlobalUsers,Long> {

    GlobalUsers findByEmployeeId(String employeeId);

}
