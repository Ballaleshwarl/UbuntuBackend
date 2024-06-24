package com.selfWebapp.selfWebappArtifact.service;

import com.selfWebapp.selfWebappArtifact.entity.LraUser;
import com.selfWebapp.selfWebappArtifact.repository.LraUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LraUserServiceImpl implements LraUserService{
    @Autowired
    private LraUserRepository lraUserRepository;


    @Override
    public LraUser findByEmail(String email) {
        return lraUserRepository.findByEmail(email);
    }



    @Override
    public String saveUser(LraUser lraUser) {
        lraUserRepository.save(lraUser);
        return "User Saved";
    }
}
