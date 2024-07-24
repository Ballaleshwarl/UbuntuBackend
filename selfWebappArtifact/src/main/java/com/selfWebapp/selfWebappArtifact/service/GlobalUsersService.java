package com.selfWebapp.selfWebappArtifact.service;

import com.selfWebapp.selfWebappArtifact.entity.GlobalUsers;

import java.util.List;


public interface GlobalUsersService {

    public boolean saveGlobalUsers(GlobalUsers globalUsers);
    public List<GlobalUsers> getAllGlobalUsers();
}
