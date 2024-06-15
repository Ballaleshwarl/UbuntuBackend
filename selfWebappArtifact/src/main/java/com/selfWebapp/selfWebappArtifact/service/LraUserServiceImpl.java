package com.selfWebapp.selfWebappArtifact.service;

import com.selfWebapp.selfWebappArtifact.entity.lraUser;
import com.selfWebapp.selfWebappArtifact.repository.LraUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class LraUserServiceImpl implements LraUserService{

    @Autowired
    private LraUserRepository lraUserRepository;

    @Override
    public String saveUser(lraUser lraUser) {
        lraUserRepository.save(lraUser);
        return "User Saved";
    }
}
