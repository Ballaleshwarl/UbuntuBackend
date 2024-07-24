package com.selfWebapp.selfWebappArtifact.service;

import com.selfWebapp.selfWebappArtifact.entity.GlobalUsers;
import com.selfWebapp.selfWebappArtifact.repository.GlobalUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GlobalUsersServiceImpl implements GlobalUsersService{

    @Autowired
    private GlobalUsersRepository globalUsersRepository;

    @Override
    public boolean saveGlobalUsers(GlobalUsers globalUsers) {
      GlobalUsers savedGlobalUser = globalUsersRepository.save(globalUsers);
      if(savedGlobalUser != null){
          return  true;
      }
        return false;
    }

    @Override
    public List<GlobalUsers> getAllGlobalUsers() {
        return globalUsersRepository.findAll();
    }
}
