package com.selfWebapp.selfWebappArtifact.service;

import com.selfWebapp.selfWebappArtifact.entity.Resource;
import com.selfWebapp.selfWebappArtifact.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService{


    @Autowired
    private ResourceRepository resourceRepository;

    @Override
    public Resource saveResource(Resource resource) {
        return  resourceRepository.save(resource);
    }
    @Override
    public List<Resource> loadResources() {
        return resourceRepository.findAll();
    }

}
