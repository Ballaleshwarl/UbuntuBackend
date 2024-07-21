package com.selfWebapp.selfWebappArtifact.service;

import com.selfWebapp.selfWebappArtifact.entity.LraUser;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public interface LraUserService {

    public String saveUser(LraUser lraUser);

    public LraUser findByEmail(String email);
}
